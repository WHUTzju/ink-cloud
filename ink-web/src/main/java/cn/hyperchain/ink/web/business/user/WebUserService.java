package cn.hyperchain.ink.web.business.user;

import cn.hyperchain.ink.core.model.page.PageResultVO;
import cn.hyperchain.ink.core.model.page.QueryPageDTO;
import cn.hyperchain.ink.core.model.token.Token;
import cn.hyperchain.ink.core.response.BaseResult;
import cn.hyperchain.ink.web.business.user.model.*;

import java.util.List;

public interface WebUserService {

    BaseResult<List<UnitVO>> queryAllUnit();

    BaseResult<List<DepartmentVO>> queryAllDepart(Token token);
    BaseResult<List<DepartmentVO>> getBelongDepart(Token token);

    BaseResult<UserInfoVO> queryUserInfo(Token token);

    BaseResult<LoginVO> login(LoginDTO loginDTO);

    BaseResult register(Token token, RegUserDTO regUserDTO);

    BaseResult freezeUser(Token token,UserFreezeDTO userFreezeDTO);

    BaseResult<PageResultVO<UserListVO>> subQueryByUserName(Token token,
                                                            QueryPageDTO queryPageDTO,
                                                            SubUserDTO subUserDTO);

    BaseResult<ResetPasswordVO> resetPwd(Token token, String userId,String password);

    BaseResult unFreezeUser(Token token, String id);
}
