package com.shareinfo.entity;

import java.io.Serializable;

/**
 * @author zxx
 * @date 2019/5/18 9:22
 * @Effect 用户信息的实体类
 */
public class UserInfo extends User implements Serializable {

    //用户性别
    private String gender;
    //用户个性签名
    private String motto;
    //用户注册时间
    private String time;
    //用户昵称
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
