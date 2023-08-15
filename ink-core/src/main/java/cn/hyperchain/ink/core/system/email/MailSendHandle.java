package cn.hyperchain.ink.core.system.email;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hyperchain.ink.core.biz.service.intf.SysMailConfigService;
import cn.hyperchain.ink.core.dao.po.SysMailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: ink
 * @description:
 * @author: inkChain
 * @create: 2023-08-14 21:58
 **/
@Slf4j
@Component
public class MailSendHandle {

    @Resource
    private SysMailConfigService mailConfigService;

    public String sendMail(MailSendMessage message) {

        List<SysMailConfig> mailList = mailConfigService.list();
        if (null == mailList || mailList.size() == 0) {
            log.info("mail error");
            return "";
        }
        SysMailConfig sysMailConfig = mailList.get(0);

        MailAccount mailAccount = convert(sysMailConfig, message.getNickname());
        String messageId = MailUtil.send(mailAccount, message.getMail(),
                message.getTitle(), message.getContent(), true);
        log.info("mail");
        return messageId;
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
