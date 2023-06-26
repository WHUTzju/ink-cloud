package cn.hyperchain.ink.core.model.token;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-20 08:49
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "user_id")
    private String uuid;

    @ApiModelProperty(value = "所属单位 1 武昌区人民检察院 2 武汉市公安局武昌分局")
    private Integer unitCode;

    /**
     * 用户角色
     */
    @ApiModelProperty(value = "user_role")
    private Integer role;
}
