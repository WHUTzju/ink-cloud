package cn.hyperchain.ink.file.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: ink-no-catch
 * @description: 不捕人员数据表 导入数据表
 * @author: inkChain
 * @create: 2023-05-22 13:18
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class NcReaderModel {

    /**
     * 部门受案号
     */
    @ExcelProperty("部门受案号")
    private String caseNumber;

    /**
     * 案件名称
     */
    @ExcelProperty("案件名称")
    private String caseName;

    /**
     * 嫌疑人姓名
     */
    @ExcelProperty("嫌疑人名称")
    private String noCatchPersonName;

    /**
     * 承办部门
     */
    @ExcelProperty("承办部门")
    private String caseDepartment;

    /**
     * 承办检察官
     */
    @ExcelProperty("承办检察官")
    private String caseProcuratorName;

    /**
     * 受理日期
     */
    @ExcelProperty("受理日期")
    private Date caseAcceptDate;


    @ExcelProperty("审结日期")
    private Date caseHearDate;

    /**
     * 不捕情形
     */
    @ExcelProperty("不捕情形")
    private String noCatchDetails;

    /**
     * 送达日期
     */
    @ExcelProperty("送达日期")
    private Date caseSendDate;

    /**
     * 执行日期
     */
    @ExcelProperty("执行日期")
    private Date casePlanSolveDate;

    /**
     * 移送人及电话
     */
    @ExcelProperty("移送人及电话")
    private String caseTransPerson;

    /**
     * 所属派出所
     */
    @ExcelProperty("所属派出所")
    private String casePoliceDepart;
}

