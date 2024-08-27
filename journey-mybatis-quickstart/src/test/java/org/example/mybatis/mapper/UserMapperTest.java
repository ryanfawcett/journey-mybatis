package org.example.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {

    @Test
    void insertUser() throws IOException{
        /*
         * 加载核心配置文件
         * 这里将从项目的根目录下加载资源，即resource目录下
         * 如果配置文件在resource下的文件夹下，例如在config文件夹下面
         * 那么这里的资源路径则为：config/mybatis-config.xml
         */
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        /*
         * 通过SQL会话工厂对象可以拿到对应的会话对象
         * 通过该对象就可以与数据库进行交互
         *
         * openSession中的参数值如果为 true，则会在执行完SQL语句后自动提交事务
         * 该参数默认为 false，即需要我们手动提交事务
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 这里通过代理创建对应的mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User("admin", "123456"));

        // 提交事务
        // sqlSession.commit();
    }

}
