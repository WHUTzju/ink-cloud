//package cn.hyperchain.ink.core.config.retrofit;
//
//import cn.hyperchain.zjchain.config.ZscqConfig;
//import cn.hyperchain.zjchain.util.FileHashUtil;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.HttpUrl;
//import okhttp3.Interceptor;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.security.NoSuchAlgorithmException;
//
///**
// * @program: iprp-zjchain
// * @description:
// * @author: inkChain
// * @create: 2024-01-08 10:56
// **/
//@Slf4j
//@Component
//public class ZscqInterceptor implements Interceptor {
//
//    private ZscqConfig zscqConfig;
//
//    @Autowired
//    public ZscqInterceptor(ZscqConfig zscqConfig) {
//        this.zscqConfig = zscqConfig;
//    }
//
//    @NotNull
//    @Override
//    public Response intercept(@NotNull Chain chain) throws IOException {
//        Request request = chain.request();
//
//        try {
//            log.info("开始签名:{}", request.url().toString());
//            HttpUrl url = request.url().newBuilder()
//                    .addQueryParameter("appkey", zscqConfig.getAppkey())
//                    .addQueryParameter("method", zscqConfig.getMethod()).build();
//            log.info("签名前:{}", url.toString());
//            String signUrl = url.newBuilder().addQueryParameter("appsecret", zscqConfig.getAppSecret()).build()
//                    .toString();
//            log.info("signUrl:{}", signUrl);
//            String sign = FileHashUtil.getStringHash(signUrl, "MD5");
//            HttpUrl newUrl = url.newBuilder().addQueryParameter("sign", sign).build();
//            log.info("签名后:{}", newUrl.toString());
//            log.info("Retrofit请求:{}", newUrl);
//            Request newReq = request.newBuilder().url(newUrl).build();
//
////            log.info("request:{}", JSONObject.toJSONString(newReq));
//            return chain.proceed(newReq);
//        } catch (NoSuchAlgorithmException e) {
//            log.error(e.getMessage(), e);
//            e.printStackTrace();
//        }
//        return chain.proceed(request);
//    }
//}
