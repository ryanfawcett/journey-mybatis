package org.example.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;

class SqlSessionUtilTest {

    @Test
    void getSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser();
        sqlSession.close();
    }
}