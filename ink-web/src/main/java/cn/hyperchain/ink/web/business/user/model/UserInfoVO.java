package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ink-no-catch
 * @description: 用户信息
 * @author: inkChain
 * @create: 2023-05-26 14:20
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoVO {

    @ApiModelProperty("用户ID")
    private String id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;


    @ApiModelProperty("用户角色     JC_ADMIN(1, 1, \"检察官\"),\n" +
            "    JC_NORMAL(11, 1, \"普通检察官\"),\n" +
            "    JC_DIRECTOR(12, 1, \"主任检察官\"),\n" +
            "    JC_CHARGE(13, 1, \"分管检察长\"),\n" +
            "    PROGRAM_MANAGER(14, 1, \"程序管理员\"),\n" +
            "    CASE_MANAGER(15, 1, \"案件管理员\"),\n" +
            "\n" +
            "    FZ_ADMIN(2, 2, \"法制员\"),\n" +
            "    FZ_INSIDE(21, 2, \"法制内勤\"),\n" +
            "    FZ_NORMAL(22, 2, \"普通法制员\"),\n" +
            "    FZ_CHIEF(23, 2, \"法制大队长\")")
    private Integer userRole;

    @ApiModelProperty("用户状态")
    private Integer isDelete;

    @ApiModelProperty("部门信息")
    private DepartmentVO departmentVO;
}
