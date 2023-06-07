package cn.hyperchain.ink.core.config.module;

import lombok.Data;

/**
 * @program: ink-no-catch
 * @description: 附件服务配置
 * @author: inkChain
 * @create: 2023-05-23 14:17
 **/
@Data
public class AttachConfig {

    /**
     * 服务URL信息 http://172.16.0.1:8080/upload/
     */
    private String server;

    /**
     * 文件目录 /opt/upload/
     */
    private String serverPath;
}
