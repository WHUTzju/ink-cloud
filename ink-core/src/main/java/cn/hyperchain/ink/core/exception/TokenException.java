package cn.hyperchain.ink.core.exception;

import cn.hyperchain.ink.core.constant.Code;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: ink-no-catch
 * @description: Token异常
 * @author: inkChain
 * @create: 2023-06-02 13:19
 **/
//@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "未授权token，请重新登录试试~~")
public class TokenException extends BaseException {
    public TokenException() {
    }

    public TokenException(Code code) {
        super(code.getCode(), code.getMsg());
    }

    public TokenException(String msg) {
        super(Code.ERROR.getCode(), msg);
    }

    public TokenException(int codeInt, String errorMsg) {
        super(codeInt, errorMsg);
    }
}
