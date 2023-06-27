    ## 简单版本项目结构


主要依赖：
- springboot: 2.7.7
- mybatis-plus: 3.1
- swagger: 2.9.2

模块：

- ink-mybatisplus-generator 代码生成模块
- ink-core 数据层、工具、swagger配置等
- ink-manager 业务api
- ink-web 业务api




### ink项目架构改造计划

设计思想
- DDD
- 分层

#####1、开发效率

- API文档：knife4j + swagger2
- 参数验证
- 通用工具
    - 加密工具
    - 日期工具
    - 分布式ID
    - …… hutools全家桶
- mybatis plus 代码生成器:
- 日志框架: logback

#####2、中间件配置
- mybatisplus
- 数据源：动态数据源、连接池、监控；多数据库（Oracle、PostgreSQL、MongoDB）
- Redis + Redisson
- 定时任务 quartz
- 分布式任务 xxl-job
- 分布式事务 Seata
- 路由限流：limit
- 熔断降级 Sentinel
- 消息队列 RabbitMQ

#####2、安全框架
- SpringSecurity+JWT+Shiro
- 权限角色
- 日志审计

#####3、三方集成
- 存储：阿里云OSS、华为云OBS
- 短信：阿里云、腾讯云
- 邮件：
- 支付：支付宝、微信
-

##### 1、微服务集成
- 注册中心 + 配置中心 Nacos
- 分布式日志 elk + kafka








