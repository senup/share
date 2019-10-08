package com.shareinfo.web;

import com.shareinfo.entity.UserInfo;
import com.shareinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxx
 * @date 2019/5/18 10:04
 * @Effect:用户信息controller层
 */
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * get user info by userId
     *
     * URL:userInfo/getUserInfoById
     *
     * @param id user's id
     * @return if success return status : 1 and userInfo else return status : 0
     */
    @RequestMapping(value = "/getUserInfoById" , method = RequestMethod.GET)
    private Map<String , Object> getUserInfoById(Integer id) {
        Map<String , Object> modelMap = new HashMap<String, Object>();
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        modelMap.put("status" , 1);
        modelMap.put("data" , userInfo);
        return modelMap;
    }

    /**
     * get user info by userId
     *
     * URL:userInfo/updateUserInfo
     *
     * @param id user's id
     * @return if success return status : 1else return status : 0
     */
    @RequestMapping(value = "/updateUserInfo" , method = RequestMethod.POST)
    private Map<String , Object> updateUserInfoById(@RequestBody UserInfo userInfo) {
        Map<String , Object> modelMap = new HashMap<String, Object>(16);
        if (userInfoService.updateUserInfo(userInfo)) {
            modelMap.put("status" , 1);
            return modelMap;
        } else {
            throw new RuntimeException("用户信息更新失败！");
        }
    }

}
