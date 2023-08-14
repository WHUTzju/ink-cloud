package cn.hyperchain.ink.core.system.interceptors;


import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.constant.BaseConstant;
import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.constant.user.UserRole;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.exception.BusinessException;
import cn.hyperchain.ink.core.exception.TokenException;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.uservice.token.TokenFactory;
import cn.hyperchain.ink.core.util.AssertUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by superlee on 2018/1/8.
 */
@Component
@Slf4j
public class RequestTokenArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenFactory tokenFactory;
    @Autowired
    private TaUserService taUserService;

    /**
     * 限定获取的参数的类型，并且有注解@RequestToken
     *
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestToken.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        RequestToken requestToken = parameter.getParameterAnnotation(RequestToken.class);
        if (null == requestToken) {
            throw new TokenException(Code.TOKEN_ERROR);
        }
        /**
         * 验证Token
         */
        String xjwtStr = webRequest.getHeader(BaseConstant.X_ACCESS_TOKEN);
//        AssertUtil.check(ObjectUtils.isEmpty(xjwtStr), Code.TOKEN_NOT_EXIST);
        AssertUtil.isNUll(xjwtStr, Code.TOKEN_NOT_EXIST);

        try {

            /**
             * 1 验证Token
             */
            Token token = tokenFactory.getTokenByJwt(xjwtStr);
            AssertUtil.check(ObjectUtils.isEmpty(xjwtStr), Code.TOKEN_ERROR);

            TaUser user = taUserService.getById(token.getUuid());
            Token token2 = tokenFactory.verifyJwtToken(user, xjwtStr);
            log.info("verify success! uuid:{}", token2.getUuid());
            /**
             * 2 验证角色
             */
            List<Integer> roleCodeList = Arrays.stream(requestToken.roles())
                    .map(UserRole::getCode).collect(Collectors.toList());

            if (!roleCodeList.contains(UserRole.NAKE.getCode())) {
                if (roleCodeList.contains(user.getUserRole())) {
                    log.info("角色验证成功 无角色限制");
                } else {
                    log.error("角色验证不成功 need roles:{}", JSON.toJSONString(Arrays.asList(requestToken.roles())));
                    throw new TokenException(Code.TOKEN_NOT_EXIST);
                }
            }
            return token2;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TokenException(Code.TOKEN_ERROR);
        }
    }

}

