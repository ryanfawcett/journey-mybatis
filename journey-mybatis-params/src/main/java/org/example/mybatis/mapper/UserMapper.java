package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.User;

import java.util.Map;

/**
 * MyBatis获取参数值的方式
 * MyBatis获取参数值的两种方式：${} 和 #{}
 * 1. ${} - 字符串拼接 需要注意引号的问题
 * 2. #{} - 占位符赋值
 *
 * @author ryanfawcett
 * @since 2024/08/31
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户详细信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * <p>
     * mapper接口的参数为多个时, mybatis会将这些参数封装到Map中, 以下面两种方式进行存储
     * <p>
     * 1. 以arg0, arg1... 为键, 以参数为值
     * 2. 以param1, param2... 为键, 以参数为值
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户详细信息
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录
     * <p>
     * 当接口的参数为多个时, 我们可以手动将这些参数存储到Map集合中进行传递
     *
     * @param map 参数集合
     * @return 用户详细信息
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     * <p>
     * 多个参数的情况下, 我们还可以直接采用实体类的方式进行传参
     *
     * @param user 用户参数
     * @return 用户详细信息
     */
    User checkLoginByEntity(User user);

    /**
     * 验证登录
     * <p>
     * 不使用Map集合与实体类的方式传递多个参数, 也可以使用@Param注解对参数进行命名
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户详细信息
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
