package org.example.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.entity.User;
import org.example.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
class UserMapperTest {

    private final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    void insertUserByMap() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", RandomUtil.randomString(10));
        user.put("password", RandomUtil.randomIntsAsString(6));

        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        log.info("正在添加用户: {}",  user.get("username"));
        int count = userMapper.insertUser(user);
        Assertions.assertEquals(1, count);
        log.info("用户: {} 添加成功！", user.get("username"));

        sqlSession.close();
    }

    @Test
    void insertUserByEntity() {
        User user = new User(null, RandomUtil.randomString(10), RandomUtil.randomIntsAsString(6));

        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        log.info("正在添加用户: {}",  user.getUsername());
        int count = userMapper.insertUserByEntity(user);
        Assertions.assertEquals(1, count);
        log.info("用户：{} 添加成功！", user.getUsername());

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
                    log.info("正在删除用户：{}", username);

                    int count = userMapper.deleteUserById(user.getId());
                    Assertions.assertEquals(1, count);

                    log.info("用户：{} 删除成功！", username);
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
                    log.info("正在为用户：{} 修改密码...", username);

                    String newPassword = RandomUtil.randomIntsAsString(6);
                    log.info("新密码为：{}", newPassword );

                    user.setPassword(newPassword);
                    int count = userMapper.updateUser(user);
                    Assertions.assertEquals(1, count);
                    log.info("用户：{} 密码修改成功！", username);
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
                    log.info("正在查找用户：{} 的全部信息", username);

                    User user = userMapper.selectUserById(anyUser.getId());
                    Assertions.assertNotNull(user);
                    log.info("用户：{} 的详细信息：{}", username, user);
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