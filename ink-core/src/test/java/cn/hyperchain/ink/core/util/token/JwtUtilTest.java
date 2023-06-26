package cn.hyperchain.ink.core.util.token;


import cn.hyperchain.ink.core.model.token.Token;
import com.alibaba.fastjson.JSONObject;
import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.StandardCharsets;


public class JwtUtilTest {


    @Test
    public void createJwtToken() {

        Token token = new Token();
        token.setUuid("037262daaae5104c1f969ba2c95d5950");
        token.setRole(1);
        token.setUnitCode(1);
        String password = "sifa@134";
        String secretKey = Hashing.md5().hashBytes(password.getBytes(StandardCharsets.UTF_8)).toString();
        String jwt = JwtUtil.createJwt(token, secretKey, 24 * 60 * 60 * 1000L);

        System.out.println("jwt:" + jwt);
    }

    @Test
    public void getTokenStrWithoutSig() {
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoxLCJ1bml0RGVzcCI6IuatpuaYjOWMuuS6uuawkeajgOWvn-mZoiIsInVuaXRDb2RlIjoxLCJ1dWlkIjoiMDM3MjYyZGFhYWU1MTA0YzFmOTY5YmEyYzk1ZDU5NTAiLCJqdGkiOiIxZGY1ZDdmOS03N2Q5LTQ0MTAtYTA0NC03NjQ2MjZiYzUxZmQiLCJpYXQiOjE2ODUwOTI1MzUsImlzcyI6Imh5cGVyY2hhaW4iLCJleHAiOjE2ODUxNzg5MzV9.xNebDSX-SyleSSkPocFUqhKrFIPWih1-ibCJh2LCieQ";
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoxLCJ1bml0Q29kZSI6MSwidXVpZCI6IjAzNzI2MmRhYWFlNTEwNGMxZjk2OWJhMmM5NWQ1OTUwIiwianRpIjoiZjdkMmI2ZDYtZDExNS00Zjc2LTg0ZDMtMzZjYzBkNGEzNTJjIiwiaWF0IjoxNjg1MDkyNzQwLCJpc3MiOiJoeXBlcmNoYWluIiwiZXhwIjoxNjg1MTc5MTQwfQ.q5y3pC0RpiHvLvhl09KjSLKk9DVafZE6KYuGemVi8rY";

        String password = "sifa@134";
        String secretKey = Hashing.md5().hashBytes(password.getBytes(StandardCharsets.UTF_8)).toString();

        Token str = JwtUtil.getTokenStrWithoutSig(jwt, Token.class);
        Token token = JwtUtil.parseJwt(jwt, secretKey, Token.class);

        System.out.println(JSONObject.toJSONString(token));
    }

    @Test
    public void t_01(){
        String password="sifa@134";
        String secretKey = Hashing.md5().hashBytes(password.getBytes(StandardCharsets.UTF_8)).toString();
        System.out.println(secretKey);
    }
}