package org.example.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class UserMapperTest {

    @Test
    void insertUser() {
        // 1. 获取配置文件输入流
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2. 创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 3. 获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            // 4. 获取SqlSession
            sqlSession = sqlSessionFactory.openSession(true);
            // 5. 获取UserMapper对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser();
        } catch (IOException e) {
            System.out.println("caused by: " + e.getCause());
        } finally {
            if (Objects.nonNull(sqlSession)) {
                sqlSession.close();
            }

            if (Objects.nonNull(is)) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("caused by: " + e.getCause());
                }
            }
        }

    }

}
