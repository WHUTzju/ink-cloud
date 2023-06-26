package cn.hyperchain.ink.web.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @program: ink-no-catch
 * @description: 新增用户DTO
 * @author: inkChain
 * @create: 2023-05-22 17:06
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegUserDTO {
    /**
     * 登录用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 登录密码
     */
    @NotBlank(message = "用户密码不能为空")
    @ApiModelProperty("用户密码")
    private String userPassword;


    /**
     * 登录角色
     * ADMIN(0, "管理员"),
     * JC_ADMIN(10, "检察官"),
     * JC_NORMAL(11, "普通检察官"),
     * JC_DIRECTOR(12, "主任检察官"),
     * JC_CHARGE(13,"分管检察长"),
     * PROGRAM_MANAGER(14,"程序检查员"),
     * CASE_MANAGER(15,"案件管理员"),
     * <p>
     * GA_ADMIN(20, "公安"),
     * <p>
     * FZ_ADMIN(30,"法制员"),
     * FZ_INSIDE(31,"法制内勤"),
     * FZ_NORMAL(32,"普通法制员"),
     * FZ_CHIEF(33,"法制大队长");
     */
    @ApiModelProperty(value = "用户角色")
    private Integer loginRole;


    @ApiModelProperty(value = "用户所属部门ID")
    private Integer departmentId;

    @ApiModelProperty(value = "可选，法治人 管辖单位ID列表 一般包括departmentId")
    private List<Integer> departmentIdList;

}
