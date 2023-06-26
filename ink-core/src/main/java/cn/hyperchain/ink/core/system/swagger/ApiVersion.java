package cn.hyperchain.ink.core.system.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @author: charles
 * @date: 2021/12/3 12:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiVersion {

    String[] groups();

}
