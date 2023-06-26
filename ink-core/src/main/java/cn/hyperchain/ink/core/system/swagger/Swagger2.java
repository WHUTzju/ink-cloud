package cn.hyperchain.ink.core.system.swagger;


import cn.hyperchain.ink.core.config.InkConfig;
import cn.hyperchain.ink.core.constant.BaseConstant;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by superlee on 2017/11/3.
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Autowired
    private InkConfig inkConfig;

    @Bean
    public Docket createRestApiMobile() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(BaseConstant.X_ACCESS_TOKEN)
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("cn.hyperchain.ink.web.controller");
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(inkConfig.getSwaggerEnable())
                .groupName("ink-web")
                .apiInfo(apiInfo())
                .select()
                .apis(Predicates.or(selector1))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目接口调试")
                .description("测试接口连通性")
                .termsOfServiceUrl("http://cn.hyperchain.ink")
                .version("1.0")
                .build();
    }
}
