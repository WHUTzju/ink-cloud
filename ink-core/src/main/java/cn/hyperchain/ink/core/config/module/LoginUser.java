package cn.hyperchain.ink.core.config.module;

import cn.hyperchain.ink.core.dao.po.TaUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @program: ink
 * @description: 登录用户VO
 * @author: inkChain
 * @create: 2023-08-12 17:51
 **/
@Data
public class LoginUser implements UserDetails {

    @ApiModelProperty(value = "用户ID")
    private String id;


    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户登录手机号码
     */
    @ApiModelProperty(value = "用户登录手机号码")
    private String userMobile;

    /**
     * 用户角色 0-管理员 1-检察官 2-公安
     */
    @ApiModelProperty(value = "用户角色 0-管理员 1-检察官 2-公安")
    private Integer userRole;

    /**
     * 用户状态 0-正常 1-冻结
     */
    @ApiModelProperty(value = "用户状态 0-正常 1-冻结")
    private Integer userStatus;

    /**
     *  权限列表
     */
    private List<GrantedAuthority> authorities;

    public static LoginUser buildFromUser(TaUser taUser) {
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(taUser, loginUser);
        return loginUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userMobile;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
