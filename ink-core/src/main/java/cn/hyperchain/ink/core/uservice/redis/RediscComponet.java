package cn.hyperchain.ink.core.uservice.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: dorado-EviBackend
 * @description: Redis共享常量
 * @author: inkChain
 * @create: 2023-03-03 12:50
 **/
@Component
@Slf4j
public class RediscComponet {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 被放弃的证据
     */
    private final static String ABANDON_F = "ABANDON_F";

}
