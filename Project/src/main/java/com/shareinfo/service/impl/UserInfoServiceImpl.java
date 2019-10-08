package com.shareinfo.service.impl;

import com.shareinfo.entity.UserInfo;
import com.shareinfo.dao.UserDao;
import com.shareinfo.dao.UserInfoDao;
import com.shareinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**x
 * @date 2019/5/18 9:59
 * @Effect
 * @author zxx
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    UserDao userDao;

    /**
     * get user's info by userId
     *
     * @Description get user's info by userId
     * @param id
     * @return if dao is success return userInfo else throw error
     * */
    @Override
    public UserInfo getUserInfoById(Integer id) {
        UserInfo userInfo = userInfoDao.getUserInfoById(id);
        if (userInfo != null) {
            return userInfo;
        } else {
            throw new RuntimeException("可能无该用户信息");
        }
    }


    /**
     * modify user's info
     *
     * @Description modify user's info
     * @param userInfo
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        if (userInfoDao.updateUserInfo(userInfo) == 1) {
            return true;
        } else if (userDao.findUserById(userInfo.getId()) == null) {
            throw new RuntimeException("该用户不存在！！！");
        }else if (userInfoDao.updateUserInfo(userInfo) < 1){
            throw new RuntimeException("数据库修改出错！！！");
        } else {
            throw new RuntimeException("未知错误！！！");
        }
    }
}
