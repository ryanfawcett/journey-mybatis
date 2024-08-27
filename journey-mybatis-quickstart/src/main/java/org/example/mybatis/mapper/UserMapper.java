package org.example.mybatis.mapper;

import org.example.mybatis.model.User;

/**
 * MyBatis 映射文件
 * <p>
 * MyBatis 面向接口编程的两个一致:
 * <p>
 * 1.映射文件的命名空间要与mapper接口的全类名一致
 * 2.映射文件中SQL语句的id要与mapper接口中方法名一致
 *
 * @author ryanfawcett
 * @since 1.0
 */
public interface UserMapper {

    void insertUser(User user);

}
