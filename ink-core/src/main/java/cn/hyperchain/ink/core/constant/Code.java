package cn.hyperchain.ink.core.constant;

public enum Code {
    //通用部分
    UNDEFINED(-1, "未定义"),
    SUCCESS(0, "成功"),
    ERROR(1, "系统开小差"),
    PARAM_ERROR(-1, "参数错误"),

    TOKEN_EXPIRED(2001, "token已经过期"),
    TOKEN_ERROR(2002, "token验证错误"),
    TOKEN_NOT_EXIST(2003, "未授权token"),

    USER_LOGIN_ERROR(3018, "单位、姓名或密码错误"),
    USER_NOT_EXIST(3001, "用户不存在"),
    USER_EXISTED(3001, "用户已经存在"),
    USER_PWD_ERROR(3002, "用户密码错误"),
    USER_REGISTER_SUCCESS(3003, "用户注册成功"),
    USER_REGISTER_ERROR(3004, "用户注册失败"),
    USER_ROLE_DENY(3005, "用户角色权限拒绝"),
    USER_DEPART_ERROR(3016, "用户部门信息错误"),
    USER_UNIT_ERROR(3017, "用户所属单位不匹配"),

    USER_STATUS_FREEZE(3005, "用户已冻结"),
    USER_FREEZE_SUCCESS(3006, "用户冻结成功"),
    USER_FREEZE_ERROR(3007, "用户冻结失败"),

    PERSON_EXCEL_TYPE_ERROR(4001, "excel格式错误"),
    PERSON_EXCEL_ERROR(4002, "excel导入错误"),
    PERSON_EXCEL_EXPORT_ERROR(4003, "excel导出错误"),

    CASE_NOT_EXIST(5001, "不捕案件不存在"),

    ATTACH_ERROR(7001, "附件错误"),
    ATTACH_NOT_EXIST(7002, "文件不存在"),


    UNKNOWN_ABNORMAL(9999, "未知异常");


    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (Code e : Code.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    public static Code getCodeByCodeInt(int codeInt) {
        for (Code code : Code.values()) {
            if (code.getCode() == codeInt) {
                return code;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

}
