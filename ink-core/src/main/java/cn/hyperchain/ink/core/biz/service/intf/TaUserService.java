package cn.hyperchain.ink.core.biz.service.intf;

import cn.hyperchain.ink.core.dao.po.TaUser;
import cn.hyperchain.ink.core.model.page.PageResultVO;
import cn.hyperchain.ink.core.model.page.QueryPageDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 管理用户表 服务类
 * </p>
 *
 * @author inkchain
 * @since 2023-05-22
 */
public interface TaUserService extends IService<TaUser> {
    TaUser queryByUserName(String userName);

    List<TaUser> queryByDepartId(Integer departId);

    TaUser queryByNameAndUnit(String name, Integer unitCode);

    TaUser registerUser(TaUser taUser);

    TaUser freezeUserById(String userId);

    PageResultVO<TaUser> subQueryByUserName(QueryPageDTO queryPageDTO,
                                            String userName,
                                            List<Integer> roleList);
}
