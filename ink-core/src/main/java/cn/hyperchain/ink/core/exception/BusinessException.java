package cn.hyperchain.ink.core.exception;


import cn.hyperchain.ink.core.constant.Code;

/**
 * 业务异常
 */
public final class BusinessException extends BaseException {
    public BusinessException() {
    }

    public BusinessException(Code code) {
        super(code.getCode(), code.getMsg());
    }

    public BusinessException(String msg) {
        super(Code.ERROR.getCode(), msg);
    }

    public BusinessException(int codeInt, String errorMsg) {
        super(codeInt, errorMsg);
    }
}
