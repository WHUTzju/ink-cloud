package cn.hyperchain.ink.web.business.attach;

import cn.hyperchain.ink.core.response.BaseResult;
import cn.hyperchain.ink.web.business.attach.model.AttachModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface AttachService {

    BaseResult<AttachModel> upload(MultipartFile multipartFile);

    BaseResult<AttachModel> upload(MultipartFile multipartFile,Long caseId,Integer fileType);

    BaseResult<AttachModel> download(String filePath, HttpServletResponse response);
}
