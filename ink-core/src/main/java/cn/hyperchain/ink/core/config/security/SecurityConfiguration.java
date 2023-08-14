package cn.hyperchain.ink.core.config.security;

import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.uservice.token.TokenFactory;
import cn.hyperchain.ink.core.util.oConvertUtils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Map;
import java.util.Set;

/**
 * @program: ink
 * @description: SpringSecurity配置
 * <p>
 * 弃用 extends WebSecurityConfigurerAdapter 配置方式
 * 改用新的 SecurityFilterChain
 * @author: inkChain
 * @create: 2023-08-12 16:19
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private SelfAuthenticationEntryPoint unauthorizedHandler;

    @Resource
    private TokenFactory tokenFactory;

    @Resource
    private TaUserService taUserService;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        /**
         * common配置
         */
        httpSecurity
                // 开启跨域
                .cors()
                .and()
                // CSRF 禁用，因为不使用 Session
                .csrf().disable()
                // 基于 token 机制，所以不需要 Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable()
                .and()
                // 一堆自定义的 Spring Security 处理器
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable();

        // 获得 @PermitAll 带来的 URL 列表，免登录
        Multimap<HttpMethod, String> permitAllUrls = getPermitAllUrlsFromAnnotations();
        // 设置每个请求的权限
        httpSecurity
                .antMatcher(contextPath + "/**")
                // ①：全局共享规则
                .authorizeRequests()
                // 设置 @PermitAll 无需认证
                .antMatchers(HttpMethod.GET, permitAllUrls.get(HttpMethod.GET).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.POST, permitAllUrls.get(HttpMethod.POST).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.PUT, permitAllUrls.get(HttpMethod.PUT).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.DELETE, permitAllUrls.get(HttpMethod.DELETE).toArray(new String[0])).permitAll()
                .antMatchers(contextPath + "/swagger**/**").permitAll()
                .antMatchers(contextPath + "/swagger-ui.html").permitAll()
                .antMatchers(contextPath + "/webjars/**").permitAll()
                // ②：每个项目的自定义规则
                .and()
                // ③：兜底规则，必须认证
                .authorizeRequests()
                .anyRequest().authenticated()
        ;
        /**
         * 添加Jwtchain
         */
        httpSecurity.addFilterBefore(
                new LoginUserFilterChain(taUserService, tokenFactory),
                UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 获得 @PermitAll 带来的 URL 列表，免登录
        Multimap<HttpMethod, String> permitAllUrls = getPermitAllUrlsFromAnnotations();
        return (web) -> web.ignoring()
                // 设置 @PermitAll 无需认证 、过滤器
                .antMatchers(HttpMethod.GET, permitAllUrls.get(HttpMethod.GET).toArray(new String[0]))
                .antMatchers(HttpMethod.POST, permitAllUrls.get(HttpMethod.POST).toArray(new String[0]))
                .antMatchers(HttpMethod.PUT, permitAllUrls.get(HttpMethod.PUT).toArray(new String[0]))
                .antMatchers(HttpMethod.DELETE, permitAllUrls.get(HttpMethod.DELETE).toArray(new String[0]))
                .antMatchers(contextPath + "/swagger**/**")
                .antMatchers(contextPath + "/swagger-ui.html")
                .antMatchers(contextPath + "/webjars/**")
                ;
    }


    private Multimap<HttpMethod, String> getPermitAllUrlsFromAnnotations() {
        Multimap<HttpMethod, String> result = HashMultimap.create();
        // 获得接口对应的 HandlerMethod 集合
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping)
                applicationContext.getBean("requestMappingHandlerMapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        /**
         * 获得有 @PermitAll 注解的接口
         */
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethodMap.entrySet()) {
            HandlerMethod handlerMethod = entry.getValue();
            if (!handlerMethod.hasMethodAnnotation(PermitAll.class)) {
                continue;
            }
            if (entry.getKey().getPatternsCondition() == null) {
                continue;
            }
            Set<String> urls = entry.getKey().getPatternsCondition().getPatterns();
            /**
             * 根据请求方法，添加到 result 结果
             */
            entry.getKey().getMethodsCondition().getMethods().forEach(requestMethod -> {
                switch (requestMethod) {
                    case GET:
                        result.putAll(HttpMethod.GET, urls);
                        break;
                    case POST:
                        result.putAll(HttpMethod.POST, urls);
                        break;
                    case PUT:
                        result.putAll(HttpMethod.PUT, urls);
                        break;
                    case DELETE:
                        result.putAll(HttpMethod.DELETE, urls);
                        break;
                    default:
                        break;
                }
            });
        }
        return result;
    }

}
