package cn.hyperchain.ink.core.util.token;

import cn.hyperchain.ink.core.exception.BusinessException;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.util.DesUtils;
import com.alibaba.fastjson.JSON;

import javax.crypto.BadPaddingException;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-21 11:56
 **/
public class TokenUtil {

    private static String strDefaultKey = "hyperch@in";


    /**
     * DES加密LoginToken实体
     *
     * @param loginToken
     * @return
     * @throws BusinessException
     */
    public static String encryptLoginToken(Token loginToken) throws BusinessException {

        String tokenJson = JSON.toJSONString(loginToken);
        String encryptTokenStr;
        try {
            encryptTokenStr = DesUtils.encryptToken(tokenJson, strDefaultKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("token字符串加密异常");
        }
        return encryptTokenStr;
    }

    /**
     * DES解密token字符串
     *
     * @param encryptTokenStr
     * @return
     * @throws BusinessException
     */
    public static synchronized Token decryptLoginToken(String encryptTokenStr) throws BusinessException {
        try {
            String tokenStr = DesUtils.decryptToken(encryptTokenStr, strDefaultKey);
            return JSON.parseObject(tokenStr, Token.class);
        } catch (BadPaddingException bpe) {
            bpe.printStackTrace();
            throw new BusinessException("token解析密钥错误");
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("token解析异常");
        }

    }
}
