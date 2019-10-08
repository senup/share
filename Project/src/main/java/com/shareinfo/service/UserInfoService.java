package com.shareinfo.service;

import com.shareinfo.entity.UserInfo;

/**
 * @date 2019/5/18 9:31
 * @Effect
 * @author zxx
 */
public interface UserInfoService {

    /**
     * modify user's info
     *
     * @Description modify user's info
     * @param userInfo
     * @return if dao is success return true else throw error
     * */
    boolean updateUserInfo(UserInfo userInfo);

    /**
     * get user's info by userId
     *
     * @Description get user's info by userId
     * @param id
     * @return if dao is success return userInfo else throw error
     * */
    UserInfo getUserInfoById(Integer id);

}
