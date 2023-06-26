package cn.hyperchain.ink.file.model;

import cn.hyperchain.ink.file.listener.DateConverter;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

import java.util.Date;

/**
 * @program: ink-no-catch
 * @description: 已处置人员 导出数据表
 * @author: inkChain
 * @create: 2023-05-22 15:09
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class NcHandleWriterModel {


    /**
     * 嫌疑人姓名
     */
    @ExcelProperty("不捕人员姓名")
    private String noCatchPersonName;

    /**
     * 案件名称
     */
    @ExcelProperty("案件名称")
    private String caseName;

    /**
     * 受案号
     */
    @ExcelProperty("受案号")
    private String caseNumber;

    /**
     * 不捕情形
     * todo
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

    /**
     * 审结日期
     */
    @ExcelProperty(value = "审结日期", converter = DateConverter.class)
    private Date caseHearDate;


    /**
     * 处置日期
     */
    @ExcelProperty(value = "处置日期", converter = DateConverter.class)
    private Date caseActualSolveDate;

    /**
     * 人员状态， 用 1 表示未处置，2表示处理中，3表示已办结
     * todo
     */
    @ExcelProperty("人员状态")
    private String noCatchPersonStatus;

    /**
     * 承办检察官姓名
     */
    @ExcelProperty("承办检察官")
    private String caseProcuratorName;
    /**
     * 承办检察部门
     */
    @ExcelProperty("所属检察部")
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
     * 承办法制人（公安）
     */
    @ExcelProperty("承办法制员")
    private String casePoliceName;


}
