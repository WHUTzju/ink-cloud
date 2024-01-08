package cn.hyperchain.ink.core.sysconf.email;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hyperchain.ink.core.dao.po.SysMailConfig;
import org.junit.Test;

/**
 * @program: ink
 * @description:
 * @author: inkChain
 * @create: 2023-08-14 21:15
 **/
public class MailTest {

    //    private
//
//    String messageId = MailUtil.send(mailAccount, message.getMail(),
//            message.getTitle(), message.getContent(),true);

    SysMailConfig sysMailConfig = SysMailConfig
            .builder()
            .mail("zjssjzscqdjpt@163.com")
            .mailUserName("zjssjzscqdjpt@163.com")
            .mailPassword("HRXKOOFUCYADQFDV")
            .mailHost("smtp.163.com")
            .mailPort(465)
            .sslEnable(true)
            .build();

    MailSendMessage message = MailSendMessage.builder()
            .mail("zhangrui@hyperchain.cn")
            .title("测试发送邮件")
            .content("测试内容")
            .nickname("TestNickName")
            .build();

    @Test
    public void t_01() {
        MailAccount mailAccount = convert(sysMailConfig, message.getNickname());
        String messageId = MailUtil.send(mailAccount, message.getMail(),
                message.getTitle(), message.getContent(), true);
        System.out.println(messageId);
    }


    MailAccount convert(SysMailConfig mailConfig, String nickname) {
        String from = StrUtil.isNotEmpty(nickname) ? nickname + " <" + mailConfig.getMail() + ">" : mailConfig.getMail();
        return new MailAccount().setFrom(from).setAuth(true)
                .setUser(mailConfig.getMailUserName()).setPass(mailConfig.getMailPassword())
                .setHost(mailConfig.getMailHost())
                .setPort(mailConfig.getMailPort())
                .setSslEnable(mailConfig.getSslEnable());
    }
}
