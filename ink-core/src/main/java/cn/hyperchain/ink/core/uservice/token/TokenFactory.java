package cn.hyperchain.ink.core.uservice.token;

import cn.hyperchain.ink.core.config.InkConfig;
import cn.hyperchain.ink.core.constant.user.UserRole;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.util.token.JwtUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-21 19:40
 **/
@Slf4j
@Component
public class TokenFactory {

    @Autowired
    private InkConfig inkConfig;


    /**
     * 1. 创建Token对象
     * 2. 加密Token串
     * 3. 获取Jwt串
     *
     * @param user
     * @return
     */
    public String createJwtToken(TaUser user) {
        Token token = Token.builder()
                .uuid(user.getId())
                .role(UserRole.getRoleByCodeInt(user.getUserRole()).getCode())
//                .unitCode(ObjectUtils.isEmpty(department) ? UserUnit.JC_V1.getCode() : UserUnit.getByDesp(department.getDepartmentUnit()).getCode())
                .build();
        log.info("create token :{} ", JSONObject.toJSONString(token));
//        String enTokenStr = TokenUtil.encryptLoginToken(token);
//        log.info("encryTokenStr:{}", enTokenStr);
        String jwtStr = JwtUtil.createJwt(token, user.getUserPassword(),
                inkConfig.getTokenExpireMills());
        log.info("jwt:{}", jwtStr);
        return jwtStr;
    }

    /**
     * 1 从Jwt获取加密Token串
     * 2 解密Token串
     * 3 获取Token对象
     *
     * @param jwtStr
     * @return
     */
    public Token getTokenByJwt(String jwtStr) {
        Token token = JwtUtil.getTokenStrWithoutSig(jwtStr, Token.class);
//        log.info("获取Token encryTokenStr:{}", enTokenStr);
//        Token token = TokenUtil.decryptLoginToken(enTokenStr);
        log.info("获取Token:{}", JSONObject.toJSONString(token));
        return token;
    }

    public Token verifyJwtToken(TaUser user, String jwtStr) {
        Token token = JwtUtil.parseJwt(jwtStr, user.getUserPassword(), Token.class);
//        log.info("获取Token encryTokenStr:{}", enTokenStr);
//        Token token = TokenUtil.decryptLoginToken(enTokenStr);
        log.info("获取Token:{}", JSONObject.toJSONString(token));
        return token;
    }
}
