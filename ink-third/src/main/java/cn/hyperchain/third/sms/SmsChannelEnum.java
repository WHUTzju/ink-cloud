package cn.hyperchain.third.sms;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: ink
 * @description:
 * @author: inkChain
 * @create: 2023-08-15 21:34
 **/
@Getter
@AllArgsConstructor
public enum SmsChannelEnum {

    DEBUG_DING_TALK("DEBUG_DING_TALK", "调试(钉钉)"),
    ALIYUN("ALIYUN", "阿里云"),
    TENCENT("TENCENT", "腾讯云"),
//    HUA_WEI("HUA_WEI", "华为云"),
    ;

    /**
     * 编码
     */
    private final String code;
    /**
     * 名字
     */
    private final String name;

    public static SmsChannelEnum getByCode(String code) {
        return ArrayUtil.firstMatch(o -> o.getCode().equals(code), values());
    }
}
