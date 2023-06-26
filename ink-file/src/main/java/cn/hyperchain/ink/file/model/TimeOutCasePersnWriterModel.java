package cn.hyperchain.ink.file.model;

import cn.hyperchain.ink.file.listener.DateConverter;
import com.alibaba.excel.annotation.ExcelProperty;
import jdk.Exported;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class TimeOutCasePersnWriterModel {

    /**
     * 不捕人员姓名
     */
    @ExcelProperty("不捕人员姓名")
    private String noCatchPersonName;


    /**
     * 案件名称
     */
    @ExcelProperty("案件名称")
    private String caseName;

    @ExcelProperty("受案号")
    private String caseNumber;

    /**
     * 案件所属不捕类型  1：不构成犯罪不捕；2：无逮捕必要不捕；3：证据不足不捕
     */
    @ExcelProperty("所属不捕类型")
    private String noCatchFirstType;

    /**
     * 送达日期
     */
    @ExcelProperty(value = "送达日期", converter = DateConverter.class)
    private Date caseSendDate;
    /**
     * 执行日期
     */
    @ExcelProperty(value = "执行日期", converter = DateConverter.class)
    private Date casePlanSolveDate;

    @ExcelProperty(value = "审结日期", converter = DateConverter.class)
    private Date caseHearDate;

    /**
     * 计划处置日期
     */
    @ExcelProperty(value = "计划处置日期", converter = DateConverter.class)
    private Date casePlanSolveCzDate;

    /**
     * 实际处置日期
     */
    @ExcelProperty(value = "实际处置日期", converter = DateConverter.class)
    private Date caseActualSolveDate;


    /**
     * 超期天数 要计算得来
     */
    @ExcelProperty("超期天数")
    private Integer timeOutDay;

    @ExcelProperty("承办检察官")
    private String caseProcuratorName;

    /**
     * 承办检察部门
     */
    @ExcelProperty("所属检察部门")
    private String caseDepartment;

    /**
     * 所属派出所
     */
    @ExcelProperty("所属派出所")
    private String casePoliceDepart;

    /**
     * 移送人及电话
     */
    @ExcelProperty("移送人及电话")
    private String caseTransPerson;

    /**
     * 承办法制员姓名
     */
    @ExcelProperty("承办法制员")
    private String casePoliceName;
}
