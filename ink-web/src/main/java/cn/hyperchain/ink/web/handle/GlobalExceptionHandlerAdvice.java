package cn.hyperchain.ink.web.handle;


import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.exception.BusinessException;
import cn.hyperchain.ink.core.exception.TokenException;
import cn.hyperchain.ink.core.response.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author superlee
 * @date 2017/11/6
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResult handleBusinessException(BusinessException be) {
        log.error(be.getMsg());
        be.printStackTrace();

        return be.getBaseResult();
    }

    @ExceptionHandler(TokenException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResult handleTokenException(TokenException be) {
        log.error("token授权错误！");
        log.error(be.getMsg());
        be.printStackTrace();
        return be.getBaseResult();
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleDefaultException(Exception be) {
        log.error(be.getMessage());
        be.printStackTrace();
        return new BaseResult(Code.UNKNOWN_ABNORMAL.getCode(),
                Code.UNKNOWN_ABNORMAL.getMsg(), be.getMessage());
    }


}
