# Journey Of MyBatis

MyBatis 官方文档：https://mybatis.org/mybatis-3/index.html

官方中文文档：https://mybatis.org/mybatis-3/zh_CN/index.html

## 1. 开发步骤

1. 创建一个 Maven 项目，设置其打包方式为 jar
2. 引入相关依赖
   1. MyBatis
   2. MySQL
3. 编写 Mybatis 核心配置文件 - mybatis-config.xml. 注意事项如下：
    1. 配置文件的名称不是必须叫 mybatis-config.xml
    2. 文件存放的位置也不是固定的
4. 编写 Mapper.xml 文件，注意事项与 MyBatis 核心配置文件一致
5. 在 mybatis-config.xml 文件中指定 Mapper 文件的路径
6. 编写 MyBatis 程序

## 2. MYbatis 集成日志组件

### 2.1 MyBatis 中常见的日志组件

1. SLF4J
2. LOG4J
3. LOG4J2
4. STDOUT_LOGGING
5. ...

其中 STDOUT_LOGGING 是标准日志，MyBatis 已经实现了这个组件

### 2.2 如何开启日志

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 注意：设置标签只能写在这里 -->
    <settings>
	      <!-- 开启日志 -->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/journey_mybatis"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```

注意：该标签只能写在配置文件的开始位置，否则会报错

### 2.3 如何引用第三方日志实现

如果需要配置第三方的日志实现，可以在 mybatis 的配置文件中配置，也可以省略

以 slf4j 为案例，实现为 logback

1. 引入 logback 的依赖
2. 添加 logback 配置文件，文件名为 logback / logback-test.xml
3. mybatis 配置文件中相关的配置可以省略

