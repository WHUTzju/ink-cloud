package cn.hyperchain.ink.core.biz.service.impl;

import cn.hyperchain.ink.core.dao.po.SysMailConfig;
import cn.hyperchain.ink.core.dao.mapper.SysMailConfigMapper;
import cn.hyperchain.ink.core.biz.service.intf.SysMailConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮箱配置表 服务实现类
 * </p>
 *
 * @author inkchain
 * @since 2023-08-14
 */
@Service
public class SysMailConfigServiceImpl extends ServiceImpl<SysMailConfigMapper, SysMailConfig> implements SysMailConfigService {

}
