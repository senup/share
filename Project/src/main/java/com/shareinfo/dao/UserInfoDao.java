package com.shareinfo.dao;

import com.shareinfo.entity.UserInfo;

/**
 * @Effect ：对用户信息进行处理的DAO层
 * @author zxx
 */
public interface UserInfoDao {

    /**
     * modify user's info
     *
     * @Description modify user's info
     * @param userInfo
     * @return modify the number of dataBase
     * */
    int updateUserInfo(UserInfo userInfo);

    /**
     * get user's info by userId
     *
     * @Description get user's info by userId
     * @param id
     * @return userInfo's entity
     * */
    UserInfo getUserInfoById(Integer id);

    /**
     * insert null userInfo
     *
     * @Description get user's info by userId
     * @param id
     * @return Insert null userInfo number
     * */
    Integer insertNullUserInfo(Integer id);

}
