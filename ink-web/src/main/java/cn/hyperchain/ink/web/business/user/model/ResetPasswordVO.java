package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResetPasswordVO {
    @ApiModelProperty(value = "密码是否重置")
    private boolean resetPass;

    @ApiModelProperty(value = "密码为")
    private String password;
}
