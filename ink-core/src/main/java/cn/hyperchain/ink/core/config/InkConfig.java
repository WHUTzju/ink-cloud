package cn.hyperchain.ink.core.config;

import cn.hyperchain.ink.core.config.module.AttachConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @program: ink-no-catch
 * @description: 配置类
 * @author: inkChain
 * @create: 2023-05-19 20:31
 **/
@Data
@ConfigurationProperties(prefix = "ink")
@AllArgsConstructor
@NoArgsConstructor
public class InkConfig {
    /**
     * Token过期时间ms
     */
    private Long tokenExpireMills;

    /**
     * 文件配置
     */
    @NestedConfigurationProperty
    private AttachConfig attachConfig;

}
