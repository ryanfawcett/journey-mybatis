package org.example.mybatis.mapper;

import org.example.mybatis.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int insertUser(Map<String, Object> user);

    int insertUserByEntity(User user);

    int deleteUserById(Long id);

    int updateUser(User user);

    User selectUserById(Long id);

    List<User> selectAll();

}
