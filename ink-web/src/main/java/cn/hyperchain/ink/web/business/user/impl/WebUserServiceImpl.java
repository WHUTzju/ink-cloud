package cn.hyperchain.ink.web.business.user.impl;

import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.constant.Code;
import cn.hyperchain.ink.core.constant.YesOrNo;
import cn.hyperchain.ink.core.constant.user.UserRole;
import cn.hyperchain.ink.core.constant.user.UserUnit;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.exception.BusinessException;
import cn.hyperchain.ink.core.model.page.PageResultVO;
import cn.hyperchain.ink.core.model.page.QueryPageDTO;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.response.BaseResult;
import cn.hyperchain.ink.core.response.BaseResultFactory;
import cn.hyperchain.ink.core.uservice.token.TokenFactory;
import cn.hyperchain.ink.core.util.AssertUtil;
import cn.hyperchain.ink.web.business.user.UnitVO;
import cn.hyperchain.ink.web.business.user.WebUserService;
import cn.hyperchain.ink.web.business.user.model.*;
import com.alibaba.fastjson.JSON;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private TaUserService taUserService;
    @Autowired
    private TokenFactory tokenFactory;


    @Override
    public BaseResult<List<UnitVO>> queryAllUnit() {

        /**
         * 从枚举查询
         */
        List<UnitVO> unitVOList = Arrays.stream(UserUnit.values()).map(
                o -> UnitVO.builder()
                        .unitCode(o.getCode())
                        .unitDesp(o.getUnitDesp())
                        .build()
        ).collect(Collectors.toList());

        return BaseResultFactory.produceResult(Code.SUCCESS, unitVOList);
    }

    /**
     * 查询所有部门
     *
     * @param token
     * @return
     */
    @Override
    public BaseResult<List<DepartmentVO>> queryAllDepart(Token token) {

//        QueryWrapper<TaDepartment> wrapper = new QueryWrapper<>();
//        wrapper.lambda()
//                .eq(TaDepartment::getIsDelete, YesOrNo.NO.getCode())
//                .ne(TaDepartment::getDepartmentName, "武汉市公安局武昌分局")
//                .eq(TaDepartment::getDepartmentUnitCode, token.getUnitCode());
//        List<TaDepartment> list = taDepartmentService.list(wrapper);

//        List<DepartmentVO> retList = list.parallelStream()
//                .map(o -> DepartmentVO.builder()
//                        .id(o.getId())
//                        .departmentName(o.getDepartmentName())
//                        .departmentUnit(o.getDepartmentUnit())
//                        .departmentUnitCode(o.getDepartmentUnitCode())
//                        .departmentRegion(o.getDepartmentRegion())
//                        .departmentNumber(o.getDepartmentNumber())
//                        .build()).collect(Collectors.toList());
        return BaseResultFactory.produceResult(Code.SUCCESS, null);
    }

    @Override
    public BaseResult<List<DepartmentVO>> getBelongDepart(Token token) {

//        QueryWrapper<TaDepartment> wrapper = new QueryWrapper<>();
//        wrapper.lambda()
//                .eq(TaDepartment::getIsDelete, YesOrNo.NO.getCode())
//                .eq(TaDepartment::getDepartmentUnitCode, token.getUnitCode());
//        if (token.getUnitCode().equals(UserUnit.FZ_V1.getCode())) {
//            wrapper.lambda()
//                    .eq(TaDepartment::getDepartmentName, "武汉市公安局武昌分局");
//        }
//        List<TaDepartment> list = taDepartmentService.list(wrapper);
//        List<DepartmentVO> retList = list.parallelStream()
//                .map(o -> DepartmentVO.builder()
//                        .id(o.getId())
//                        .departmentName(o.getDepartmentName())
//                        .departmentUnit(o.getDepartmentUnit())
//                        .departmentUnitCode(o.getDepartmentUnitCode())
//                        .departmentRegion(o.getDepartmentRegion())
//                        .departmentNumber(o.getDepartmentNumber())
//                        .build()).collect(Collectors.toList());
        return BaseResultFactory.produceResult(Code.SUCCESS, null);
    }

    @Override
    public BaseResult<UserInfoVO> queryUserInfo(Token token) {

        TaUser user = taUserService.getById(token.getUuid());
        AssertUtil.check(ObjectUtils.isEmpty(user), Code.USER_NOT_EXIST);

        /**
         * 管辖部门
         */
//        List<TaUserDepartment> departList = taUserDepartmentService.queryByUserId(user.getId());
//        AssertUtil.check(ObjectUtils.isEmpty(departList), Code.USER_DEPART_ERROR);
//        String department = StringUtils.arrayToDelimitedString(departList.stream().map(TaUserDepartment::getDepartmentName).toArray(), ",");

//        TaDepartment department = taDepartmentService.getById(user.getUserDepartmentId());
//        AssertUtil.check(ObjectUtils.isEmpty(department), Code.USER_DEPART_ERROR);

//        if (ObjectUtils.isEmpty(user.getUserDepartmentId()) || ObjectUtils.isEmpty(department)) {

            //TODO  分管检察长没有部门 只有所属单位！！！！！！！！
            UserUnit userUnit = UserUnit.getByCode(user.getUserUnitCode());

            return BaseResultFactory.produceResult(Code.SUCCESS, UserInfoVO
                    .builder()
                    .userRole(user.getUserRole())
                    .isDelete(user.getIsDelete())
                    .userName(user.getUserName())
                    .departmentVO(DepartmentVO.builder()
                            .createTime(user.getCreateTime())
                            .departmentRegion(userUnit.getUnitRegion())
                            .departmentUnit(userUnit.getUnitDesp()) //所属单位
                            .departmentUnitCode(userUnit.getCode())
                            .build())
                    .build());
//        } else {
//            return BaseResultFactory.produceResult(Code.SUCCESS, UserInfoVO
//                    .builder()
//                    .userRole(user.getUserRole())
//                    .isDelete(user.getIsDelete())
//                    .userName(user.getUserName())
//                    .departmentVO(DepartmentVO.builder()
//                            .createTime(user.getCreateTime())
//                            .id(department.getId())
//                            .departmentName(department.getDepartmentName())
//                            .departmentNumber(department.getDepartmentNumber())
//                            .departmentRegion(department.getDepartmentRegion())
//                            .departmentUnit(department.getDepartmentUnit()) //所属单位
//                            .departmentUnitCode(department.getDepartmentUnitCode())
//                            .createPerson(user.getUserCreator())
//                            .build())
//                    .build());
//        }
    }

    /**
     * todo 采用简单的密码校验方式
     * <p>
     * md5(pwd)=md5(pwd)
     *
     * @return
     */
    @Override
    public BaseResult<LoginVO> login(LoginDTO loginDTO) {
        /**
         * 01 check 用户是否存在
         */
        TaUser user = taUserService.queryByUserName(loginDTO.getLoginAccount());
        AssertUtil.check(ObjectUtils.isEmpty(user), Code.USER_LOGIN_ERROR);

        /**
         * 02 check 用户密码
         * todo 可引入shiro auth2.0等鉴权框架
         */
        if (!checkAuth(user, loginDTO)) {
            throw new BusinessException(Code.USER_LOGIN_ERROR);
        }
        /**
         * 用户状态是否被冻结
         */
        if (!checkUserStatus(user)) {
            throw new BusinessException(Code.USER_STATUS_FREEZE);
        }
        /**
         * 03 返回Token
         */
        /**
         * 所属部门
         */
//        TaDepartment depart = taDepartmentService.getById(user.getUserDepartmentId());
//        AssertUtil.check(ObjectUtils.isEmpty(depart), Code.USER_DEPART_ERROR);
        String jwt = tokenFactory.createJwtToken(user);
        log.info("login success! jwt:{}", jwt);
        return BaseResultFactory.produceResult(
                Code.SUCCESS, LoginVO.builder()
                        .loginJwt(jwt)
                        .loginAccount(user.getUserName())
                        .loginRole(user.getUserRole())
                        .build()
        );
    }

    /**
     * 新增用户模块
     *
     * @param regUserDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult register(Token token, RegUserDTO regUserDTO) {
        // 将UserDTO转换为TaUser实体对象

//        TaUser creatUser = taUserService.getById(token.getUuid());
        /**
         * 1、用户是否重复
         * 2、构造用户
         * 3、添加管辖关系
         */
        TaUser oldUser = taUserService.queryByUserName(regUserDTO.getUserName());
        if (!ObjectUtils.isEmpty(oldUser)) {
            log.error("用户名重复");
            throw new BusinessException(Code.USER_EXISTED);
        }
        log.info("开始添加用户:{} 角色:{}", JSON.toJSONString(regUserDTO),
                UserRole.getRoleByCodeInt(regUserDTO.getLoginRole()));

        /**
         * token新增 todo
         */
        /**
         * 法制人管辖单位只能有一个
         * todo
         */
//        regUserDTO.getDepartmentIdList().forEach(id -> {
//            TaUserDepartment up = taUserDepartmentService.getById(id);
//
//        });


        TaUser taUser = new TaUser();

        taUser.setUserName(regUserDTO.getUserName());
        taUser.setUserPassword(Hashing.md5().hashBytes(
                regUserDTO.getUserPassword().getBytes(StandardCharsets.UTF_8)).toString());
        taUser.setUserRole(UserRole.getRoleByCodeInt(regUserDTO.getLoginRole()).getCode());
        taUser.setUserUnitCode(UserRole.getRoleByCodeInt(regUserDTO.getLoginRole()).getUnitCode());
        taUser.setIsDelete(YesOrNo.NO.getCode());
//        taUser.setUserCreator(creatUser.getUserName());

        if (!ObjectUtils.isEmpty(regUserDTO.getDepartmentId())) {
            taUser.setUserDepartmentId(regUserDTO.getDepartmentId());
        }

        TaUser newTaUser = taUserService.registerUser(taUser);
        log.info("register success! :{}", newTaUser.getId());


        /**
         * 添加管辖关系
         */
        return BaseResultFactory.produceEmptyResult(Code.SUCCESS);
    }

    /**
     * 冻结用户模块
     *
     * @param userFreezeDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult freezeUser(Token token, UserFreezeDTO userFreezeDTO) {
        TaUser newTaUser = taUserService.freezeUserById(userFreezeDTO.getId());
        log.info("freeze success! :{}", newTaUser.getId());
        return BaseResultFactory.produceEmptyResult(Code.SUCCESS);
    }

    /**
     * 解冻用户模块
     *
     * @param token
     * @param userId
     * @return
     */
    @Override
    public BaseResult unFreezeUser(Token token, String userId) {
        /**
         * todo 权限验证
         */

        TaUser user = taUserService.getById(userId);
        user.setIsDelete(YesOrNo.NO.getCode());
        taUserService.updateById(user);
        log.info("unnFreeze success! :{}", user.getId());
        return BaseResultFactory.produceEmptyResult(Code.SUCCESS);
    }

    @Override
    public BaseResult<PageResultVO<UserListVO>> subQueryByUserName(Token token, QueryPageDTO queryPageDTO, SubUserDTO subUserDTO) {

        List<Integer> roleList = UserRole.getRoleByUnit(UserUnit.getByCode(token.getUnitCode()));

        PageResultVO<TaUser> pageResultVO = taUserService.subQueryByUserName(queryPageDTO,
                subUserDTO.getUserName(),
                roleList
        );

        List<UserListVO> list = pageResultVO.getRecords()
                .stream().map(user -> {
                    UserListVO vo = UserListVO.builder()
                            .build();
                    BeanUtils.copyProperties(user, vo);
                    vo.setUserRoleName(UserRole.getRoleByCodeInt(user.getUserRole()).getRoleName());
                    /**
                     * 查询所属部门
                     */
//                    TaDepartment depart = taDepartmentService.getById(user.getUserDepartmentId());
//                    if (!ObjectUtils.isEmpty(depart)) {
//                        vo.setUserDepartmentId(user.getUserDepartmentId());
//                        vo.setDepartmentName(depart.getDepartmentName());
//                    }
                    return vo;
                }).collect(Collectors.toList());

        PageResultVO<UserListVO> voList = new PageResultVO<>();
        voList.setTotal(pageResultVO.getTotal());
        voList.setRecords(list);
        return BaseResultFactory.produceResult(
                Code.SUCCESS, voList
        );
    }

    @Override
    public BaseResult<ResetPasswordVO> resetPwd(Token token, String userId, String password) {

        TaUser user = taUserService.getById(userId);
        AssertUtil.check(ObjectUtils.isEmpty(user), Code.USER_NOT_EXIST);
        /**
         * todo 权限验证
         */

        /**
         * 2 修改密码
         */
        //Random random = new Random();
        //int size = BaseConstant.RANDOM_LIST.size();
        //String resetPwd = BaseConstant.RANDOM_LIST.get(random.nextInt(size)) + NumUtil.randomCode(3);

        String resetPwd = password;
        log.info("resetPwd:{}", resetPwd);
        user.setUserPassword(
                Hashing.md5().hashBytes(
                        resetPwd.getBytes(StandardCharsets.UTF_8)).toString()
        );

        boolean ret = taUserService.updateById(user);

        return BaseResultFactory
                .produceResult(Code.SUCCESS, ResetPasswordVO.builder()
                        .resetPass(ret)
                        .password(resetPwd)
                        .build());
    }


    /**
     * check pwd
     *
     * @param user
     * @param loginDTO
     * @return
     */
    private Boolean checkAuth(TaUser user, LoginDTO loginDTO) {
        if (!user.getUserUnitCode().equals(loginDTO.getUnitCode())) {
            throw new BusinessException(Code.USER_LOGIN_ERROR);
        }
        if (StringUtils.hasText(loginDTO.getLoginPassword())) {
            return user.getUserPassword().equals(loginDTO.getLoginPassword());
        }
        return false;
    }

    private Boolean checkUserStatus(TaUser user) {
        if (user.getIsDelete() == 0) {
            return true;
        }
        return false;
    }

    private static String formatDateToYearMonthDay(Date date) {
        // 将 Date 对象转换为 LocalDate 对象
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 格式化为年月日字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }
}
