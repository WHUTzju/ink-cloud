package cn.hyperchain.ink.core.biz.service.intf;

import cn.hyperchain.ink.core.dao.po.TaAttachment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 附件表 服务类
 * </p>
 *
 * @author inkchain
 * @since 2023-05-23
 */
public interface TaAttachmentService extends IService<TaAttachment> {

    List<TaAttachment> getByCaseId(Long caseId);
}
