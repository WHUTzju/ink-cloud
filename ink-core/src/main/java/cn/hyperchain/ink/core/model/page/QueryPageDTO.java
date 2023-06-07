package cn.hyperchain.ink.core.model.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装查询条件
 */
@Builder
@AllArgsConstructor
@Data
public class QueryPageDTO implements Serializable{

    @ApiModelProperty(value = "当前页码")
    private Integer currentPage;

    @ApiModelProperty(value = "每页显示的记录条数")
    private Integer pageSize;

    public QueryPageDTO() {
        this.currentPage = 1;
        this.pageSize = 12;
    }

}