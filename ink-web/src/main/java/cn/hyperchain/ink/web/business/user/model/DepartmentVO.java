package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {
    @ApiModelProperty("部门创建人")
    private String createPerson;

    @ApiModelProperty("部门ID")
    private Long id;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("部门所属单位")
    private String departmentUnit;

    @ApiModelProperty("部门所属单位Code")
    private Integer departmentUnitCode;

    @ApiModelProperty("部门创建时间")
    private Date createTime;

    @ApiModelProperty("部门编号")
    private Integer departmentNumber;

    @ApiModelProperty("部门区域")
    private String departmentRegion;
}
