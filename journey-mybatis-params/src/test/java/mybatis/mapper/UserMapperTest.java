package mybatis.mapper;

import org.example.mybatis.entity.User;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class UserMapperTest {

    @Test
    void getUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("FlclvEczrL");
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    void checkLogin() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("FlclvEczrL","963980");
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    void checkLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "FlclvEczrL");
        map.put("password", "963980");
        User user = mapper.checkLoginByMap(map);
        System.out.println("user = " + user);

        sqlSession.close();
    }

    @Test
    void checkLoginByEntity() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByEntity(new User("FlclvEczrL", "963980"));
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    void checkLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("FlclvEczrL", "963980");
        System.out.println("user = " + user);
        sqlSession.close();
    }

}