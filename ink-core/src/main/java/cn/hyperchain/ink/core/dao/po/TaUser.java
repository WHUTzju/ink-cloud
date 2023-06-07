package cn.hyperchain.ink.core.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理用户表
 * </p>
 *
 * @author inkchain
 * @since 2023-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TaUser extends Model<TaUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

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
     * 用户名
     */
    private String userName;

    /**
     * 用户登录手机号码
     */
    private String userMobile;

    /**
     * 用户登录密码（加盐md5）
     */
    private String userPassword;

    /**
     * 用户角色 0-管理员 1-检察官 2-公安
     */
    private Integer userRole;

    /**
     * 用户状态 0-正常 1-冻结
     */
    private Integer userStatus;

    /**
     * 用户登陆失败次数
     */
    private Integer failTimes;

    /**
     * 用户创建人
     */
    private String userCreator;

    /**
     * 用户所属部门ID
     */
    private Integer userDepartmentId;

    /**
     * 所属单位 1-检察、2-公安
     */
    private Integer userUnitCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
