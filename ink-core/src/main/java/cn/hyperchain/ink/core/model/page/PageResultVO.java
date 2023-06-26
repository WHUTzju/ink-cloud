package cn.hyperchain.ink.core.model.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResultVO<T> implements Serializable{

    @ApiModelProperty(value = "查询列表总记录数")
    private Long total;

    @ApiModelProperty(value = "当前页结果")
    private List<T> records;

}
