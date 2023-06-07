package cn.hyperchain.ink.core.biz.service.impl;

import cn.hyperchain.ink.core.biz.service.intf.TaUserService;
import cn.hyperchain.ink.core.constant.YesOrNo;
import cn.hyperchain.ink.core.dao.mapper.TaUserMapper;
import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.model.page.PageResultVO;
import cn.hyperchain.ink.core.model.page.QueryPageDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 管理用户表 服务实现类
 * </p>
 *
 * @author inkchain
 * @since 2023-05-22
 */
@Service
public class TaUserServiceImpl extends ServiceImpl<TaUserMapper, TaUser> implements TaUserService {

    @Autowired
    private TaUserMapper taUserMapper;

    @Override
    public TaUser queryByUserName(String userName) {
        QueryWrapper<TaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("is_delete", YesOrNo.NO.getCode())
                .eq("user_name", userName);
        List<TaUser> list = this.list(queryWrapper);
        return ObjectUtils.isEmpty(list) || list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<TaUser> queryByDepartId(Integer departId) {
        if (ObjectUtils.isEmpty(departId)) {
            return null;
        }
        QueryWrapper<TaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(TaUser::getUserDepartmentId, departId);
        return this.list(queryWrapper);
    }

    @Override
    public TaUser queryByNameAndUnit(String name, Integer unitCode) {
        QueryWrapper<TaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(TaUser::getIsDelete, YesOrNo.NO.getCode())
                .eq(TaUser::getUserName, name)
                .eq(TaUser::getUserUnitCode, unitCode);

        List<TaUser> list = this.list(queryWrapper);
        return ObjectUtils.isEmpty(list) || list.size() == 0 ? null : list.get(0);
    }

    @Override
    public TaUser registerUser(TaUser taUser) {
        QueryWrapper<TaUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(taUser);
        taUserMapper.insert(taUser);
        return taUser;
    }

    @Override
    public TaUser freezeUserById(String userId) {
        TaUser user = this.getById(userId);
        taUserMapper.deleteById(userId);
        /**
         * 若用户具备管辖单位 顺便一起删除
         */
//        List<TaUserDepartment> udList = taUserDepartmentService.queryByUserId(userId);
//        if (!ObjectUtils.isEmpty(udList)) {
//            taUserDepartmentService.getBaseMapper().delete(new UpdateWrapper<TaUserDepartment>()
//                    .lambda().eq(TaUserDepartment::getUserId, userId)
//                    .set(TaUserDepartment::getIsDelete, YesOrNo.YES.getCode()));
//        }
        // user.setIsDelete(YesOrNo.YES.getCode());
        //user.setUserStatus(UserStatus.FROZEN.getCode());
        //taUserMapper.updateById(user);
        return user;
    }


    @Override
    public PageResultVO<TaUser> subQueryByUserName(QueryPageDTO queryPageDTO,
                                                   String userName,
                                                   List<Integer> roleList) {
        Page<TaUser> page = new Page<>(queryPageDTO.getCurrentPage(), queryPageDTO.getPageSize());

        QueryWrapper<TaUser> queryWrapper = new QueryWrapper<>();
        // 根据需要设置查询条件
        if (StringUtils.hasText(userName)) {
            queryWrapper.like("user_name", "%" + userName + "%");
        }
        if (!ObjectUtils.isEmpty(roleList) && roleList.size() > 0) {
            queryWrapper.in("user_role", roleList);
        }
        // queryWrapper.eq("user_status",UserStatus.NORMAL.getCode());
        queryWrapper.eq("is_delete", YesOrNo.NO.getCode());
        IPage<TaUser> userPage = this.page(page, queryWrapper);
        PageResultVO<TaUser> pageResultVO = new PageResultVO<TaUser>();
        BeanUtils.copyProperties(userPage, pageResultVO);
        return pageResultVO;
    }
}
