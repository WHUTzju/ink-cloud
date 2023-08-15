package cn.hyperchain.ink.core.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 邮箱配置表
 * </p>
 *
 * @author inkchain
 * @since 2023-08-14
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMailConfig extends Model<SysMailConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除0:否1:是
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 发送者邮箱
     */
    private String mail;

    /**
     * 发送者邮箱
     */
    private String mailUserName;

    /**
     * 发送者邮箱
     */
    private String mailPassword;

    /**
     * 发送者邮箱
     */
    private String mailHost;

    /**
     * 发送者邮箱
     */
    private Integer mailPort;

    /**
     * 发送者邮箱
     */
    private Boolean sslEnable;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
