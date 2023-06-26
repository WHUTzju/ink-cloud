package cn.hyperchain.ink.web.business.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ink-no-catch
 * @description: 所属单位返回结构体
 * @author: inkChain
 * @create: 2023-05-26 13:55
 **/

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UnitVO {

    @ApiModelProperty("所属单位code")
    private Integer unitCode;
    @ApiModelProperty("所属单位描述")
    private String unitDesp;
}
