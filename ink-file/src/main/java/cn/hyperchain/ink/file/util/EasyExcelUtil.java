package cn.hyperchain.ink.file.util;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-22 13:08
 **/
@Slf4j
public class EasyExcelUtil {

    private static List<String> AllowSuffixList = new ArrayList<String>() {
        {
            add(".xlsx");
        }
    };

    /**
     * 仅允许 xlsx格式文件导入
     *
     * @param fileName
     * @return
     */
    public static boolean isExcel(
            String fileName
    ) {
        if (null == fileName) {
            return false;
        }
        String suffix = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : fileName;
        return AllowSuffixList.contains(suffix);
    }

    public static boolean readFile(File file, Class head, ReadListener listener) {
        if (!isExcel(file.getName())) {
            log.info("excel 格式不正确:{}", file.getAbsolutePath());
            return false;
        }
        EasyExcel.read(file, head, listener)
                .sheet().doRead();
        return true;
    }


}
