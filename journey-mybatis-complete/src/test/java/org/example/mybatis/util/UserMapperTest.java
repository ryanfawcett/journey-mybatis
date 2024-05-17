package org.example.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.entity.User;
import org.example.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class UserMapperTest {

    @Test
    void insertUserByMap() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", RandomUtil.randomString(10));
        user.put("password", RandomUtil.randomIntsAsString(6));

        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("正在添加用户: " + user.get("username"));
        int count = userMapper.insertUser(user);
        Assertions.assertEquals(1, count);
        System.out.println("用户: " + user.get("username") + " 添加成功！");

        sqlSession.close();
    }

    @Test
    void insertUserByEntity() {
        User user = new User(null, RandomUtil.randomString(10), RandomUtil.randomIntsAsString(6));

        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("正在添加用户: " + user.getUsername());
        int count = userMapper.insertUserByEntity(user);
        Assertions.assertEquals(1, count);
        System.out.println("用户: " + user.getUsername() + " 添加成功！");

        sqlSession.close();
    }

    @Test
    void deleteUserById() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.selectAll();
        allUsers.stream()
                .findAny()
                .ifPresent(user -> {
                    String username = user.getUsername();
                    System.out.println("正在删除用户：" + username);

                    int count = userMapper.deleteUserById(user.getId());
                    Assertions.assertEquals(1, count);

                    System.out.println("用户: " + username + " 删除成功！");
                });

        sqlSession.close();
    }

    @Test
    void updateUser() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUsers = userMapper.selectAll();
        allUsers.stream()
                .findAny()
                .ifPresent(user -> {
                    String username = user.getUsername();
                    System.out.println("正在为用户: " + username + " 修改密码...");

                    String newPassword = RandomUtil.randomIntsAsString(6);
                    System.out.println("新密码为: " + newPassword);

                    user.setPassword(newPassword);
                    int count = userMapper.updateUser(user);
                    Assertions.assertEquals(1, count);
                    System.out.println("用户: " + username + " 密码修改成功！");
                });

        sqlSession.close();
    }

    @Test
    void selectUserById() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.selectAll();

        allUsers.stream()
                .findAny()
                .ifPresent(anyUser -> {
                    String username = anyUser.getUsername();
                    System.out.println("正在查找用户: " + username + " 的全部信息");

                    User user = userMapper.selectUserById(anyUser.getId());
                    Assertions.assertNotNull(user);
                    System.out.println("用户: " + username + " 的详细信息: " + user);
                });

        sqlSession.close();
    }

    @Test
    void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);

        sqlSession.close();
    }
}