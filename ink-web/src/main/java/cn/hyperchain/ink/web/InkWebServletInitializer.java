package cn.hyperchain.ink.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 部署到外部tomcat容器中
 */
public class InkWebServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InkWebApplication.class);
	}

}
