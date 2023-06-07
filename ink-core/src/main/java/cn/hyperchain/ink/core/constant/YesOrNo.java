package cn.hyperchain.ink.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: ink-no-catch
 * @description:
 * @author: inkChain
 * @create: 2023-05-26 09:23
 **/
@AllArgsConstructor
@Getter
public enum YesOrNo {
    YES(1, "是"),
    NO(0, "否");
    private Integer code;
    private String desc;
}
