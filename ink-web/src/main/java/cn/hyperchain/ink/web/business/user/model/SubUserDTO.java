package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubUserDTO {

    @ApiModelProperty("用户名")
    private String userName;
}
