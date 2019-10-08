package com.shareinfo.service;

import com.shareinfo.entity.User;
import com.shareinfo.entity.UserInfo;

import java.util.List;

/**
 * @author DengShenglin
 **/


public interface UserService {

    /**
     * find all user
     *
     * @Description find all user
     * @param void
     * @return if dao is success return userList else throw error
     * */
    User findUserById(Integer id);

    /**
     * Verify Register
     *
     * @Description Verify Register
     * @param user user's object
     * @return if dao is success return true else throw error
     * */
    String VerifyRegister(User user);

    /**
     * find userName whether or not exist
     *
     * @Description find userName whether or not exist
     * @param userName user's name
     * @return if dao is success return true else throw error
     * */
    User UserNameExist(String userName);

    /**
     * find user by userName
     *
     * @Description find user by userName
     * @param userName user's name
     * @return if dao is success return user else throw error
     * */
    User findUserByName(String userName);

    /**
     * add user
     *
     * @Description add user
     * @param user user's object
     * @return if dao is success return user else throw error
     * */
    User register(User user);

    /**
     * modify user password
     *
     * @Description modify user password
     * @param user user's object
     * @return if dao is success return user else throw error
     * */
    User passwordChange(User user);

    /**
     * find user by userId
     *
     * @Description find user by userId
     * @param id user's id
     * @return if dao is success return user else throw error
     * */
    List<UserInfo> findAll();

}
