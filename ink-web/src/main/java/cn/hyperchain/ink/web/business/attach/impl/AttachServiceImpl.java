package cn.hyperchain.ink.web.business.attach.impl;

import cn.hyperchain.ink.core.biz.service.intf.TaAttachmentService;
import cn.hyperchain.ink.core.config.InkConfig;
import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.dao.po.TaAttachment;
import cn.hyperchain.ink.core.exception.BusinessException;
import cn.hyperchain.ink.core.response.BaseResult;
import cn.hyperchain.ink.core.response.BaseResultFactory;
import cn.hyperchain.ink.core.util.AssertUtil;
import cn.hyperchain.ink.core.util.FileHashUtil;
import cn.hyperchain.ink.web.business.attach.AttachService;
import cn.hyperchain.ink.web.business.attach.model.AttachModel;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-23 14:15
 **/

@Slf4j
@Service
public class AttachServiceImpl implements AttachService {

    private static String PATTERN = "yyyy-MM-dd";

    @Autowired
    private InkConfig inkConfig;
    @Autowired
    private TaAttachmentService taAttachmentService;

    @PostConstruct
    public void init() {
        log.info("file config:{}", JSONObject.toJSONString(inkConfig.getAttachConfig()));
    }

    @Override
    public BaseResult<AttachModel> upload(MultipartFile multipartFile) {

        return upload(multipartFile, null, null);
    }

    @Override
    public BaseResult<AttachModel> upload(MultipartFile multipartFile, Long caseId, Integer fileType) {
        AssertUtil.check(ObjectUtils.isEmpty(multipartFile), Code.ERROR);
        /**
         * 1、fileHash
         * 2、fileName:
         * 3、ab_filePath=inkConfig.att_path+"/"+filePath
         */
        try {
            String fileHash = FileHashUtil.getFileHashByFile(multipartFile);
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : fileName;

            String folderName = new SimpleDateFormat(PATTERN).format(new Date());
            File fileDir = new File(inkConfig.getAttachConfig().getServerPath() + File.separator + folderName);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            String filePath = folderName + File.separator + fileHash + suffix;
            File file = new File(inkConfig.getAttachConfig().getServerPath() + File.separator + filePath);
            multipartFile.transferTo(file);
            log.info("文件上传至:{} 访问地址:{}", file.getAbsolutePath(),
                    inkConfig.getAttachConfig().getServer() + File.separator + filePath);

            /**
             * 入库
             */
            TaAttachment attachment = new TaAttachment();
            attachment.setFileHash(fileHash);
            attachment.setFileName(fileName);
            attachment.setFilePath(filePath);
            if (null != caseId) {
                attachment.setCaseId(caseId);
            }
            if (null != fileType) {
                attachment.setFileType(fileType);
            }
            taAttachmentService.save(attachment);

            return BaseResultFactory.produceResult(Code.SUCCESS,
                    AttachModel.builder()
                            .fileHash(fileHash)
                            .filePath(filePath)
                            .fileName(fileName)
                            .fileUrl(inkConfig.getAttachConfig().getServer() + File.separator + filePath)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("文件上传失败:{}", multipartFile.getOriginalFilename());
            throw new BusinessException(Code.ATTACH_ERROR);
        }
    }

    @Override
    public BaseResult<AttachModel> download(String filePath, HttpServletResponse response) {

        QueryWrapper<TaAttachment> wrapper = new QueryWrapper<TaAttachment>();
        wrapper.eq("file_path", filePath);
        wrapper.eq("is_delete", false);
        List<TaAttachment> list = taAttachmentService.list(wrapper);
        if (ObjectUtils.isEmpty(list) || list.size() == 0) {
            log.error("数据库 文件不存在:{}", filePath);
            throw new BusinessException(Code.ATTACH_NOT_EXIST);
        }
        TaAttachment attachment = list.get(0);

        File file = new File(inkConfig.getAttachConfig().getServerPath() + File.separator + filePath);
        if (!file.exists()) {
            log.error("服务器 文件不存在:{}", filePath);
            throw new BusinessException(Code.ATTACH_NOT_EXIST);
        }

        /**
         * 下载流设置
         */
        setDownLoad(file, attachment.getFileName(), response);

        return BaseResultFactory.produceResult(Code.SUCCESS,
                AttachModel.builder()
                        .fileHash(attachment.getFileHash())
                        .filePath(attachment.getFilePath())
                        .fileName(attachment.getFileName())
                        .fileUrl(inkConfig.getAttachConfig().getServer() + File.separator + filePath)
                        .build());
    }


    private void setDownLoad(File file, String fileName, HttpServletResponse response) {

        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            log.info("rawFileName:{}", file.getName());

            //设置响应头
            // 设置信息给客户端不解析,设置contenttype，即告诉客户端所发送的数据属于什么类型
//            response.setHeader("Content-type", new MimetypesFileTypeMap().getContentType(file.getAbsolutePath()));
            // 设置编码
//            String code = new String(file.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。

//            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
//            response.setContentType("application/octet-stream");
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.setCharacterEncoding("utf-8");
            outputStream = response.getOutputStream();
            inputStream = new FileInputStream(file);

            byte[] results = FileCopyUtils.copyToByteArray(inputStream);
            outputStream.write(results);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }

    }
}
