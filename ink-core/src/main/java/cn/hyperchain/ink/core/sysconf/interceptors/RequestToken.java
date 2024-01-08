package cn.hyperchain.ink.core.sysconf.interceptors;

import cn.hyperchain.ink.core.constant.user.UserRole;

import java.lang.annotation.*;

/**
 * Created by superlee on 2018/1/8.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
@Inherited
public @interface RequestToken {
    UserRole[] roles() default UserRole.NAKE;
}
