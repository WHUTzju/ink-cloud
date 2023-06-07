package cn.hyperchain.ink.web.controller;

import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-21 20:37
 **/

public class TokenUtilTest {

    @Test
    public void t_01() {
        //String pwd = "sifa@134";//94c62a2df2d47a66f719e52394d1430d
        //String pwd = "zhangsan";//01d7f40760960e7bd9443513f22ab9af
        String pwd = "lisi";//dc3a8f1670d65bea69b7b65048a0ac40
        String md5Str = Hashing.md5().hashBytes(pwd.getBytes(StandardCharsets.UTF_8)).toString();
        System.out.println(md5Str);
    }
}
