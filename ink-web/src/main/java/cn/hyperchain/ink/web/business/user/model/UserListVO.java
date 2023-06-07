package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-28 12:28
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserListVO {
    @ApiModelProperty("用户ID")
    private String id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户角色")
    private Integer userRole;
    @ApiModelProperty("角色名称")
    private String userRoleName;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("所属部门名称")
    private String departmentName;

    /**
     * 用户所属部门ID
     */
    @ApiModelProperty("所属部ID")
    private Integer userDepartmentId;

    @ApiModelProperty("创建人")
    private String userCreator;
}
