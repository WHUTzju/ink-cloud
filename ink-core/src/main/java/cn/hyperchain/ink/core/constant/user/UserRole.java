package cn.hyperchain.ink.core.constant.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN(0, 0, null, "管理员"),
    NAKE(99, 0, null, "无权限"),

    JC_ADMIN(1, 1, UserUnit.JC_V1, "检察官"),
    JC_NORMAL(11, 1, UserUnit.JC_V1, "普通检察官"),
    JC_DIRECTOR(12, 1, UserUnit.JC_V1, "主任检察官"),
    JC_CHARGE(13, 1, UserUnit.JC_V1, "分管检察长"),
    PROGRAM_MANAGER(14, 1, UserUnit.JC_V1, "程序管理员"),
    CASE_MANAGER(15, 1, UserUnit.JC_V1, "案件管理员"),

    FZ_ADMIN(2, 2, UserUnit.FZ_V1, "法制员"),
    FZ_INSIDE(21, 2, UserUnit.FZ_V1, "法制内勤"),
    FZ_NORMAL(22, 2, UserUnit.FZ_V1, "普通法制员"),
    FZ_CHIEF(23, 2, UserUnit.FZ_V1, "法制大队长");


    /**
     * 角色code码
     */
    private int code;
    /**
     * 第一角色 属于1-检察、2-公安
     */
    private int unitCode;
    private UserUnit userUnit;
    /**
     * 角色描述
     */
    private String roleName;

    public static UserRole getRoleByCodeInt(int codeInt) {
        for (UserRole e : UserRole.values()) {
            if (e.getCode() == codeInt) {
                return e;
            }
        }
        throw new IllegalArgumentException("未定义的roleName码:" + codeInt);
    }


    public static List<Integer> getRoleByFirstCode(int firstCode) {

        List<Integer> roleList = new ArrayList<>();
        for (UserRole e : UserRole.values()) {
            if (e.getUnitCode() == firstCode) {
                roleList.add(e.getCode());
            }
        }
        return roleList;
    }

    public static List<Integer> getRoleByUnit(UserUnit userUnit) {

        List<Integer> roleList = new ArrayList<>();
        for (UserRole e : UserRole.values()) {
            if (e.getUnitCode() == userUnit.getCode()) {
                roleList.add(e.getCode());
            }
        }
        return roleList;
    }

    public static int getCodeByRoleName(String roleName) {
        for (UserRole code : UserRole.values()) {
            if (code.getRoleName().equals(roleName)) {
                return code.getCode();
            }

        }
        throw new IllegalArgumentException("未定义的roleName:" + roleName);
    }


}
