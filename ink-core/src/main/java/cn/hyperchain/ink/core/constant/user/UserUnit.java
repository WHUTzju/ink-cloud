package cn.hyperchain.ink.core.constant.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserUnit {
    JC_V1(1, "武昌区人民检察院", "武汉市武昌区"),
    FZ_V1(2, "武汉市公安局武昌分局", "武汉市武昌区");

    @ApiModelProperty("所属单位code")
    private Integer code;
    @ApiModelProperty("所属单位描述")
    private String unitDesp;
    @ApiModelProperty("所属单位位置")
    private String unitRegion;


    public static UserUnit getByDesp(String unitDesp) {
        for (UserUnit userUnit : UserUnit.values()) {
            if (unitDesp.equals(userUnit.getUnitDesp())) {
                return userUnit;
            }
        }
        return JC_V1;
    }


    public static UserUnit getByCode(int code) {
        for (UserUnit userUnit : UserUnit.values()) {
            if (code == userUnit.getCode()) {
                return userUnit;
            }
        }
        return JC_V1;
    }
}
