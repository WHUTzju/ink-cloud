package cn.hyperchain.ink.core.config.retrofit;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @program: zq-backend
 * @description:
 * @author: inkChain
 * @create: 2023-10-11 20:06
 **/
public class MyCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        return null;
    }

    //这里写步骤2、3的内容和一些必要的初始化 参考RxJavaCallAdapter

    //这个决定了你将采取什么样的CallAdapter
//    @Override
//    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
//        //获取returnType的原始类型  如 CustomCall<R>
//        Class<?> rawType = getRawType(returnType);
//        //返回值的类型必须是CustomCall<>  并且带有泛型
//        if (rawType == CustomCall.class && returnType instanceof ParameterizedType) {
//
//            //获取returnType泛型的类型  如Call<MovieDataBean>中的MovieDataBean
//            Type callReturnType = getParameterUpperBound(0, (ParameterizedType) returnType);
//            //使用CustomCallAdapter转换处理数据
//            return new CallAdapter<CustomCall<?>>{
//
//            };
//        } else {
//            return null;
//        }
//    }
}