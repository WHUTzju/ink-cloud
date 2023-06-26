package cn.hyperchain.ink;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用于生成po/mapper/services
 * @Author: fuyongchao
 * @Date: 2021/6/25 10:48
 */
public class Main {

    private static final String outputDir = "out";

    private static final String[] tableName = {
            //  "admin_user"
//            "ta_timeout_case",
//            "ta_timeout_case"
//            "ta_attachment"
//            "ta_warn",
//            "ta_warn_record"
//                 "ta_case_process"
            "ta_timeout_case",
            //   "ta_case_message"
//            "ta_user_department",
//            "ta_user",
//            "ta_no_catch_person"
//            "ta_department"
//            "ta_case_todo"
            "ta_disposed_of_case"
    };


    //数据库配置
//    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/no_catch?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String dbUrl = "jdbc:mysql://rm-bp1627pvs05272j1evo.mysql.rds.aliyuncs.com:3306/no_catch_test?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=false&useOldAliasMetadataBehavior=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8";
    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";

    private static final String dbUserName = "writer";
    private static final String dbPassword = "HyperFLY@W";

    private static final String devAuthor = "inkchain";

    private static final String parentPackage = "cn.hyperchain.ink.core";

    private static final String datasourcePackageName = "dao";

    public static void main(String[] args) throws SQLException {

        // 1. 全局配置

        GlobalConfig config = new GlobalConfig();

        config.setOutputDir(outputDir); //生成路径
        config.setAuthor(devAuthor); //作者
        config.setFileOverride(true); // 文件覆盖
        config.setActiveRecord(true);// 是否支持AR模式
        config.setEnableCache(false);// XML 二级缓存
        config.setBaseResultMap(true);// XML ResultMap
        config.setBaseColumnList(true);// XML columList
        config.setOpen(false);//是否打开目录
        config.setDateType(DateType.ONLY_DATE);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");


        // 2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL); // 设置数据库类型
        dsConfig.setDriverName(dbDriver);
        dsConfig.setUrl(dbUrl);
        dsConfig.setUsername(dbUserName);
        dsConfig.setPassword(dbPassword);

        // 3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //stConfig.setCapitalMode(true); // 全局大写命名
        stConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        stConfig.setEntityLombokModel(true);
        stConfig.setRestControllerStyle(true);
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        stConfig.setTableFillList(tableFillList);
        stConfig.setLogicDeleteFieldName("is_delete");

        stConfig.setInclude(tableName); // 生成的表


        // 4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(parentPackage)
                .setMapper(datasourcePackageName + ".mapper")// dao
                .setService("biz.service.intf")// servcie
                .setServiceImpl("biz.service.impl")
                .setController("controller")// controller
                .setEntity(datasourcePackageName + ".po")
                .setXml(datasourcePackageName + ".mapper");// mapper.xml

        // 5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config);
        ag.setDataSource(dsConfig);
        ag.setStrategy(stConfig);
        ag.setPackageInfo(pkConfig);

        // 6. 执行
        ag.execute();
    }

}
