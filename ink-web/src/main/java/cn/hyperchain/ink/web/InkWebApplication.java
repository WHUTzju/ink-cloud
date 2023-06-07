package cn.hyperchain.ink.web;

import cn.hyperchain.ink.core.config.InkConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableScheduling
@EnableTransactionManagement
@EnableConfigurationProperties({InkConfig.class})
@MapperScan(basePackages = {"cn.hyperchain.ink.*.dao"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "cn.hyperchain.ink.*")
public class InkWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkWebApplication.class, args);
    }

}
