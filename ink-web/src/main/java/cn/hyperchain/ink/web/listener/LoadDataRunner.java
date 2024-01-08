package cn.hyperchain.ink.web.listener;


import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: iprp-zjchain
 * @description:
 * @author: inkChain
 * @create: 2023-11-17 10:56
 **/
@Slf4j
@Component
@Order(value = 10)
public class LoadDataRunner implements CommandLineRunner {


    @Resource
    private RedissonClient redissonClient;

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 LoadDataRunner order 10 <<<<<<<<<<<<<");

        /**
         * 之江链数据处理 -- 已执行
         */
//        pullDataService.loadAllData();;

        /**
         * 备案补充数据处理-- 已执行
         */
//        EasyExcel.read(new File("/Users/zhangrui/Downloads/登记变更备案记录上传数据汇总-修正1229.xlsx"), DataRegDTO.class,
//                new DataRegListener(list -> {
//                    list.forEach(
//                            dataRegDTO -> {
//                                propertyDataRegRegisterTask.insertDataRegRegister(dataRegDTO);
//                            });
//                })).sheet().doRead();


        //for test
//        RLock lock = redissonClient.getLock("key");
//        try {
//            log.info("lock.getName(){},lock.isLocked(){},lock.getHoldCount(){}", lock.getName(), lock.isLocked(), lock.getHoldCount());
//            lock.lock();
//            RLock lock2 = redissonClient.getLock("key");
//            log.info("lock.getName(){},lock.isLocked(){},lock.getHoldCount(){}", lock2.getName(), lock2.isLocked(), lock2.getHoldCount());
//        } finally {
//            lock.unlock();
//            log.info("lock.getName(){},lock.isLocked(){},lock.getHoldCount(){}", lock.getName(), lock.isLocked(), lock.getHoldCount());
//        }
    }
}
