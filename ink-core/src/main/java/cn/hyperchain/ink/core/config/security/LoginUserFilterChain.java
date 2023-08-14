package cn.hyperchain.ink.core.config.security;

import cn.hutool.core.util.StrUtil;
import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.config.module.LoginUser;
import cn.hyperchain.ink.core.constant.BaseConstant;
import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.exception.TokenException;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.uservice.token.TokenFactory;
import cn.hyperchain.ink.core.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ink
 * @description:
 * @author: inkChain
 * @create: 2023-08-12 17:45
 **/
@Slf4j
@RequiredArgsConstructor
public class LoginUserFilterChain extends OncePerRequestFilter {


    private TokenFactory tokenFactory;

    private TaUserService taUserService;

    public LoginUserFilterChain(TaUserService taUserService, TokenFactory tokenFactory) {
        this.taUserService = taUserService;
        this.tokenFactory = tokenFactory;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /**
         * cong header get token
         */
        LoginUser loginUser = buildLoginUserByHeader(request);
        if (null == loginUser) {
            throw new TokenException(Code.TOKEN_ERROR);
        }
        /**
         * set loginUser
         */
        LoginUserUtils.setLoginUser(loginUser, request);
        // 继续过滤链
        filterChain.doFilter(request, response);
    }

    private LoginUser buildLoginUserByHeader(HttpServletRequest request) {
        String xjwtStr = request.getHeader(BaseConstant.X_ACCESS_TOKEN);
        /**
         * 1 验证Token
         */
        try {
            Token token = tokenFactory.getTokenByJwt(xjwtStr);
            AssertUtil.check(ObjectUtils.isEmpty(xjwtStr), Code.TOKEN_ERROR);
            TaUser taUser = taUserService.getById(token.getUuid());
            tokenFactory.verifyJwtToken(taUser, xjwtStr);
            log.info("verify success! uuid:{}", taUser.getId());
            return LoginUser.buildFromUser(taUser);
        } catch (Exception e) {
            log.error("token verify error! xjwtStr:{}", xjwtStr);
            e.printStackTrace();
            return null;
        }
    }


}
