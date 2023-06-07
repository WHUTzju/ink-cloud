package cn.hyperchain.ink.web.controller;


import cn.hyperchain.ink.core.biz.service.intf.TaNoCatchPersonService;
import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.web.InkWebApplication;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;


@Slf4j
@SpringBootTest(classes = InkWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminUserControllerTest {

    @Autowired
    private TaUserService taUserService;

    @Autowired
    private TaNoCatchPersonService taNoCatchPersonService;




    @Test
    public void createUser() {
        String pwd = "sifa@134";
        TaUser user = new TaUser();
        user.setId("4");
        user.setUserMobile("15557006867");
        user.setUserName("张三");
        user.setUserPassword(Hashing.md5().hashBytes(pwd.getBytes(StandardCharsets.UTF_8)).toString());
        user.setUserRole(1);
        user.setFailTimes(0);
        user.setIsDelete(0);
      //  user.setUserStatus(0);

        boolean result = taUserService.save(user);

        log.info("insert result:{}", result);
    }
}