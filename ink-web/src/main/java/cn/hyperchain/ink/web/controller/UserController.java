package cn.hyperchain.ink.web.controller;


import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.constant.user.UserRole;
import cn.hyperchain.ink.core.model.page.QueryPageDTO;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.response.BaseResult;
import cn.hyperchain.ink.core.response.BaseResultFactory;
import cn.hyperchain.ink.core.system.interceptors.RequestToken;
import cn.hyperchain.ink.web.business.user.UnitVO;
import cn.hyperchain.ink.web.business.user.WebUserService;
import cn.hyperchain.ink.web.business.user.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 * 管理用户表 前端控制器
 * </p>
 *
 * @author inkchain
 * @since 2023-05-22
 */
@Api(value = "用户管理模块", description = "用户管理模块")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private WebUserService webUserService;


    @ApiOperation(value = "获取所有所属单位")
    @GetMapping("/allUnit")
    public BaseResult<List<UnitVO>> queryAllUnit() {
        return webUserService.queryAllUnit();
    }

    @ApiOperation(value = "获取所有管辖单位")
    @GetMapping("/allDepartment")
    public BaseResult<List<DepartmentVO>> queryAllDepartment(
            @ApiIgnore @RequestToken Token token
    ) {
        return webUserService.queryAllDepart(token);
    }

    @ApiOperation(value = "获取所有所属部门")
    @GetMapping("/getBelongDepart")
    public BaseResult<List<DepartmentVO>> getBelongDepart(
            @ApiIgnore @RequestToken Token token
    ) {
        return webUserService.getBelongDepart(token);
    }


    /**
     * 用户登陆
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation(value = "登录接口", notes = "登录接口")
    @PostMapping("/login")
    public BaseResult login(@RequestBody LoginDTO loginDTO) {
        return webUserService.login(loginDTO);
    }

    @ApiOperation(value = "用户信息", notes = "用户信息")
    @GetMapping("/userInfo")
    public BaseResult<UserInfoVO> queryUserinfo(
            @ApiIgnore @RequestToken Token token) {
        return webUserService.queryUserInfo(token);
    }


    /**
     * 用户新增
     *
     * @param regUserDTO
     * @return
     */
    @ApiOperation(value = "新增用户模块", notes = "新增用户模块")
    @PostMapping("/register")
    public BaseResult register(
            @ApiIgnore @RequestToken(roles = {UserRole.FZ_INSIDE, UserRole.PROGRAM_MANAGER}) Token token,
            @ApiParam("    JC_ADMIN(1, 1, \"检察官\"),\n" +
                    "    JC_NORMAL(11, 1, \"普通检察官\"),\n" +
                    "    JC_DIRECTOR(12, 1, \"主任检察官\"),\n" +
                    "    JC_CHARGE(13, 1, \"分管检察长\"),\n" +
                    "    PROGRAM_MANAGER(14, 1, \"程序管理员\"),\n" +
                    "    CASE_MANAGER(15, 1, \"案件管理员\"),\n" +
                    "\n" +
                    "    FZ_ADMIN(2, 2, \"法制员\"),\n" +
                    "    FZ_INSIDE(21, 2, \"法制内勤\"),\n" +
                    "    FZ_NORMAL(22, 2, \"普通法制员\"),\n" +
                    "    FZ_CHIEF(23, 2, \"法制大队长\");") @RequestBody RegUserDTO regUserDTO) {
        return webUserService.register(token, regUserDTO);
    }

    /**
     * 冻结用户/删除用户
     *
     * @param userFreezeDTO
     * @return
     */
    @ApiOperation(value = "冻结用户模块", notes = "冻结用户模块")
    @PostMapping("/freeze")
    public BaseResult freezeUser(
            @ApiIgnore @RequestToken(roles = {UserRole.FZ_INSIDE, UserRole.PROGRAM_MANAGER}) Token token,
            @RequestBody UserFreezeDTO userFreezeDTO) {

        return webUserService.freezeUser(token, userFreezeDTO);
    }

    /**
     * 解冻用户
     *
     * @param userUnFreezeDTO
     * @return
     */
    @ApiOperation(value = "解冻用户模块", notes = "解冻用户模块")
    @PostMapping("/unFreeze")
    public BaseResult unFreezeUser(
            @ApiIgnore @RequestToken(roles = {UserRole.FZ_INSIDE, UserRole.PROGRAM_MANAGER}) Token token,
            @RequestBody UserUnFreezeDTO userUnFreezeDTO) {
        return webUserService.unFreezeUser(token, userUnFreezeDTO.getId());
    }

    @ApiOperation(value = "查询下属成员", notes = "根据用户名查询用户")
    @GetMapping("/searchSubUser")
    public BaseResult searchSubUser(
            @ApiIgnore @RequestToken(roles = {UserRole.FZ_INSIDE, UserRole.PROGRAM_MANAGER}) Token token,
            @ApiParam("当前页") @RequestParam(defaultValue = "1") Integer currentPage,
            @ApiParam("页面大小") @RequestParam(defaultValue = "5") Integer pageSize,
            @ApiParam("用户名") @RequestParam(required = false) String userName) {
        return webUserService.subQueryByUserName(token,
                QueryPageDTO
                        .builder()
                        .currentPage(currentPage)
                        .pageSize(pageSize)
                        .build(),
                SubUserDTO.builder()
                        .userName(userName)
                        .build());
    }


    /**
     * 重置密码
     *
     * @param
     * @return
     */
    @ApiOperation(value = "重置密码", notes = "用户id重置密码")
    @PostMapping("/resetPassword")
    public BaseResult<ResetPasswordVO> resetPassword(
            @ApiIgnore @RequestToken(roles = {UserRole.FZ_INSIDE, UserRole.PROGRAM_MANAGER}) Token token,
            @ApiParam("根据用户UUID修改用户密码") ResetPasswordDTO resetPasswordDTO
    ) {
        return webUserService.resetPwd(token, resetPasswordDTO.getId(), resetPasswordDTO.getUserPassword());
    }
}



