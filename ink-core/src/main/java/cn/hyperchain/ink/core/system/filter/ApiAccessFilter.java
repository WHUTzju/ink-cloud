package cn.hyperchain.ink.core.system.filter;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by zhangrui on 2019/7/31.
 * cn.hyperchain.tracidence.core.system.filter
 */
@Slf4j
@WebFilter(filterName = "filter_time", urlPatterns = {"/*"})
@Component
public class ApiAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 请求进入时间
        log.info("[Api Access] start uri: {}, method: {}",
                request.getRequestURI(), request.getMethod());
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        log.info("[Api Access] end.  uri: {}, 耗时duration: {}ms", request.getRequestURI(),
                System.currentTimeMillis() - startTime);

    }

    @Override
    public void destroy() {

    }

    @Getter
    @Setter
    class ApiAccessLogInfo {
        /**
         * 请求url
         */
        private String requstUri;
        /**
         * 请求头
         */
        private Map<String, String[]> requestParameter;
        /**
         * 请求方式
         */
        private String method;
        /**
         * 请求体
         */
        private String body;
        /**
         * 响应状态
         */
        private Integer responsestatus;
        /**
         * 响应数据
         */
        private String response;
        /**
         * 接口开始毫秒
         */
        private Long startTime;


        @Override
        public String toString() {
            return "请求日志{" +
                    "请求url='" + requstUri + '\'' +
                    ", url拼接参数=" + JSON.toJSONString(requestParameter) +
                    ", 请求方式='" + method + '\'' +
                    ", 请求体='" + body + '\'' +
                    ", 响应状态=" + responsestatus +
                    ", 响应数据='" + response + '\'' +
                    ", 接口消耗毫秒=" + (System.currentTimeMillis() - startTime) +
                    '}';
        }
    }

}
