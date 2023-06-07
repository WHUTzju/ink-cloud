package cn.hyperchain.ink.core.biz.service.impl;

import cn.hyperchain.ink.core.constant.YesOrNo;
import cn.hyperchain.ink.core.dao.po.TaAttachment;
import cn.hyperchain.ink.core.dao.mapper.TaAttachmentMapper;
import cn.hyperchain.ink.core.biz.service.intf.TaAttachmentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 *
 * @author inkchain
 * @since 2023-05-23
 */
@Service
public class TaAttachmentServiceImpl extends ServiceImpl<TaAttachmentMapper, TaAttachment> implements TaAttachmentService {

    @Override
    public List<TaAttachment> getByCaseId(Long caseId) {

        QueryWrapper<TaAttachment> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(TaAttachment::getIsDelete, YesOrNo.NO.getCode())
                .eq(TaAttachment::getCaseId, caseId);
        return this.list(wrapper);
    }
}
