package com.shareinfo.dao;

import com.shareinfo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DengShenglin
 * 用户Dao接口
 **/

public interface UserDao {

    /**
     * find all user
     *
     * @Description find all user
     * @param void
     * @return user's list
     * */
    List<User> findAll();

    /**
     * find user by userName
     *
     * @Description find user by userName
     * @param userName user's name
     * @return user
     * */
    User findUserByName(String userName);

    /**
     * add user
     *
     * @Description add user
     * @param user user's object
     * @return Number of items affecting the database
     * */
    int saveUser(User user);

    /**
     * delete user
     *
     * @Description delete user
     * @param user user's object
     * @return Number of items affecting the database
     * */
    int deleteUser(User user);

    /**
     * modify user password
     *
     * @Description modify user password
     * @param user user's object
     * @return Number of items affecting the database
     * */
    int updateUser(User user);

    /**
     * find user by userId
     *
     * @Description find user by userId
     * @param id user's id
     * @return user
     * */
    User findUserById(@Param("id") Integer id);
}
