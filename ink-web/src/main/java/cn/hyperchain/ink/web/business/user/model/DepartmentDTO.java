package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    /**
     * 部门id
     */
    @NotBlank
    @ApiModelProperty("用户Id-UUID")
    private String id;


}
