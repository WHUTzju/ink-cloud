package cn.hyperchain.file;

import cn.hyperchain.ink.file.listener.NoCatchModelListener;
import cn.hyperchain.ink.file.model.NcReaderModel;
import cn.hyperchain.ink.file.model.NcWriterModel;
import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-22 13:51
 **/
public class EasyExcelTest {

    @Test
    public void t_01() {
        String filePath = "/Users/zhangrui/Downloads/不捕数据表0522.xlsx";
        NoCatchModelListener listener = new NoCatchModelListener(
                100,
                l -> {
                    System.out.println(l.size());
                }
        );
        EasyExcel.read(filePath, NcReaderModel.class, listener)
                .sheet().doRead();
        EasyExcel.read(new File(filePath), NcReaderModel.class, listener)
                .sheet().doRead();

    }


    @Test
    public void t_02() {
//        String filePath = "/Users/zhangrui/Downloads/不捕导出数据表0522_2.xlsx";
        String filePath = "C:\\Users\\chenchuang\\Desktop\\test\\不捕人员导出表.xlsx";

        List<NcWriterModel> writerModelList = new ArrayList<NcWriterModel>() {
            {
                add(NcWriterModel.builder()
                        .noCatchPersonName("张三")
                        .caseName("张三开设赌场")
                        .noCatchFirstType("不构成犯罪不捕")
                        .caseSendDate(new Date())
//                        .caseActualSolveDate(new Date())
                        .caseProcuratorName("张伟")
                        .noCatchPersonStatus("未处置")
                        .build());
                add(NcWriterModel.builder()
                        .noCatchPersonName("张三")
                        .caseName("张三开设赌场")
                        .noCatchFirstType("不构成犯罪不捕")
                        .caseSendDate(new Date())
//                        .caseActualSolveDate(new Date())
                        .caseProcuratorName("张伟")
                        .noCatchPersonStatus("未处置")
                        .build());

            }
        };


        EasyExcel.write(new File(filePath), NcWriterModel.class)
                .sheet()
                .doWrite(writerModelList);

    }

}
