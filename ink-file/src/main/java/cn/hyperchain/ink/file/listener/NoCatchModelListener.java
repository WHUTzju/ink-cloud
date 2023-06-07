package cn.hyperchain.ink.file.listener;

import cn.hyperchain.ink.file.model.NcReaderModel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-22 13:42
 **/
@Slf4j
public class NoCatchModelListener implements ReadListener<NcReaderModel> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static Integer BATCH_COUNT = 100;
    private static Integer TOTAL_COUNT = 0;

    private static List<NcReaderModel> ncReaderModelList;
    private static Consumer<List<NcReaderModel>> consumer;

    public NoCatchModelListener(Integer batchSize, Consumer<List<NcReaderModel>> consu) {
        ncReaderModelList = new ArrayList<>();
        log.info("noCatchModelList init ...");
        consumer = consu;
        if (batchSize != 0) {
            BATCH_COUNT = batchSize;
        }
    }

    @Override
    public void invoke(NcReaderModel data, AnalysisContext context) {
        if (ncReaderModelList.size() >= BATCH_COUNT) {
            log.info("excel数据数量达到:{} 开始执行consume", BATCH_COUNT);
            consumer.accept(ncReaderModelList);
            ncReaderModelList.clear();
        }
        if (null != data) {
            ncReaderModelList.add(data);
            TOTAL_COUNT++;
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

        try {
            log.info("excel 解析完成 执行consume");
            if (ncReaderModelList.size() > 0) {
                consumer.accept(ncReaderModelList);
            }
            log.info("excel 全部解析执行完成 total:{}", TOTAL_COUNT);
        } finally {
            ncReaderModelList.clear();
        }
    }
}
