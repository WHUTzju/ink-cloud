package cn.hyperchain.ink.core.util;


import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.exception.BusinessException;

import java.util.function.Consumer;

/**
 * @author wanghaifeng
 * @description 断言工具类
 * @date 2020/2/10
 */
public class AssertUtil {

    public static void check(boolean condition, Code code) {
        if (condition) {
            throw new BusinessException(code);
        }
    }

    public static void check(boolean condition, String message) {
        if (condition) {
            throw new BusinessException(Code.ERROR.getCode(), message);
        }
    }

    public static void check(boolean condition, int code,String message) {
        if (condition) {
            throw new BusinessException(code,message);
        }
    }

    public static void expect(Object value,Object dest, Code code) {
        if (!value.equals(dest)) {
            throw new BusinessException(code);
        }
    }

    public static void isNUll(Object object, Code code) {
        check(object == null, code);
    }

    /**
     * 校验是否为null 抛出指定异常 并支持自定义打印日志
     *
     * @param object
     * @param code
     * @param consumer
     */
    public static void isNullWithLog(Object object, Code code, Consumer<Object> consumer) {
        if (object == null) {
            consumer.accept(object);
        }

        isNUll(object == null, code);
    }
}
