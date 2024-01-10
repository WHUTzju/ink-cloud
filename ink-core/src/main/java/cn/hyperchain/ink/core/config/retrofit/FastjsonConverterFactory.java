package cn.hyperchain.ink.core.config.retrofit;

import com.alibaba.fastjson.JSON;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import org.springframework.stereotype.Component;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;


@Component
public class FastjsonConverterFactory extends Converter.Factory {

    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");


    public static FastjsonConverterFactory create() {
        return new FastjsonConverterFactory();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return (Converter<?, RequestBody>) value -> RequestBody.create(MEDIA_TYPE, JSON.toJSONString(value).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        return (Converter<ResponseBody, ?>) value -> {
            BufferedSource bufferedSource = Okio.buffer(value.source());
            String tempStr = bufferedSource.readUtf8();
            bufferedSource.close();
            return JSON.parseObject(tempStr, type);
        };

    }
}
