package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ink-no-catch
 * @description: 登录返回
 * @author: inkChain
 * @create: 2023-05-21 20:29
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginVO {
    /**
     * 登录角色
     */
    @ApiModelProperty(value = "登陆账号名")
    private String loginAccount;
    @ApiModelProperty(value = "登录角色")
    private Integer loginRole;
    @ApiModelProperty(value = "登录后的Jwt")
    private String loginJwt;
}
