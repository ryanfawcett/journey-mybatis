package org.example.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.entity.User;
import org.example.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserMapperTest {

    @Test
    void insertUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", "zhangsan");
        user.put("password", "123456");

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.insertUser(user);
        Assertions.assertEquals(1, count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void insertUserByEntity() {
        User user = new User(null, "lisi", "123456");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.insertUserByEntity(user);
        Assertions.assertEquals(1, count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void deleteUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.deleteUserById(8L);
        Assertions.assertEquals(1, count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(1);
        user.setPassword("1234");

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.updateUser(user);
        Assertions.assertEquals(1, count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void selectUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1L);
        Assertions.assertNotNull(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        Assertions.assertNotNull(users);
        users.forEach(System.out::println);

        sqlSession.commit();
        sqlSession.close();
    }
}