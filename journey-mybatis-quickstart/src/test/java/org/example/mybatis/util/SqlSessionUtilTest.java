package org.example.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.model.User;
import org.junit.jupiter.api.Test;

class SqlSessionUtilTest {

    @Test
    void getSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(new User("admin", "123456"));
        sqlSession.close();
    }
}