package cn.hyperchain.ink.web.business.user.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;


/**
 * @program: ink-no-catch
 * @description: 登录信息DTO
 * @author: inkChain
 * @create: 2023-05-21 19:06
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    /**
     * 登录用户名
     */
    @NotBlank
    @ApiModelProperty("用户名")
    private String loginAccount;
    /**
     * 登录密码
     */
    @NotBlank
    @ApiModelProperty("密码 md5(明文）")
    private String loginPassword;

    /**
     * 单位选择
     */
    @ApiModelProperty("所属单位 ")
    private Integer unitCode;
}
