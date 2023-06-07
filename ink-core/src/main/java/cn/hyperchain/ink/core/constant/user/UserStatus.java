package cn.hyperchain.ink.core.constant.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {

    NORMAL(0, "正常"),
    FROZEN(1, "冻结");

    private int code;
    private String msg;
}
