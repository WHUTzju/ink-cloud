package cn.hyperchain.ink.core.constant;

/**
 * @author cmt
 * @Title:
 * @date 2019/8/20 11:49 AM
 */
public enum RedisCacheType {
    USER(0, "user"),
    APP(1, "app"),
    COIN_NOTIFY(2, "user:code:uid");

    private int code;
    private String msg;

    RedisCacheType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (RedisCacheType e : RedisCacheType.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    }
