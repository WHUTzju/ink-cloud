package cn.hyperchain.ink.core.config.retrofit;

import cn.hutool.core.date.StopWatch;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.GlobalInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program:
 * @description:
 * @author: inkChain
 * @create: 2023-10-11 23:37
 **/
@Slf4j
@Component
public class SourceGlobalInterceptor implements GlobalInterceptor {


    @Override
    public Response intercept(Chain chain) throws IOException, IOException {
        Request request = chain.request();
        log.info("Retrofit请求:{}", request.url());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        String responseStr = null;
        if (null != responseBody) {
            BufferedSource source = responseBody.source();

            source.request(Long.MAX_VALUE);
            Buffer buffer = source.getBuffer();
            responseStr = buffer.clone().readString(StandardCharsets.UTF_8);
        }
        stopWatch.stop();
        log.info("Retrofit 耗时:{}ms 返回:{}", stopWatch.getTotalTimeMillis(), responseStr);
        return response;
    }
}