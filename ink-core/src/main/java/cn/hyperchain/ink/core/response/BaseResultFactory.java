package cn.hyperchain.ink.core.response;


import cn.hyperchain.ink.core.constant.Code;

public final class BaseResultFactory {


    public static BaseResult produceEmptyResult(Code code) {
        return new BaseResult(code);
    }

    public static BaseResult produceEmptyResult(int codeInt, String msg) {
        return new BaseResult(codeInt, msg);
    }

    public static <T> BaseResult<T> produceResult(int codeInt, String msg, T data) {
        return new BaseResult<T>(codeInt, msg, data);
    }

    public static <T> BaseResult<T> produceResult(Code code, T data) {
        return new BaseResult<T>(code.getCode(), code.getMsg(), data);
    }


}
