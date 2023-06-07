package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResetPasswordDTO {
    /**
     * 用户Id
     */
    @NotBlank(message = "用户名Id不能为空")
    @ApiModelProperty("用户Id-UUID")
    private String id;

    /**
     * 登录密码
     */
    @NotBlank(message = "重置密码不能为空")
    @ApiModelProperty("重置用户密码")
    private String userPassword;
}
