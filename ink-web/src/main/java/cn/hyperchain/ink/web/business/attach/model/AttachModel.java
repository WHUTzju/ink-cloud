package cn.hyperchain.ink.web.business.attach.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-23 14:39
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttachModel {

    private Long id;
    private String fileHash;
    private String fileName;
    private String filePath;
    private String fileUrl;
}
