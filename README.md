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