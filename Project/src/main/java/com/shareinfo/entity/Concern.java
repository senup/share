package com.shareinfo.entity;

import java.io.Serializable;

/**
 *
 * id表示该实体的本身用户的id
 * 关注的实体类
 * id：关注者
 * userName:关注者的名字
 * concernId:为被关注者id
 * concernUserNam:被关注者的名字
 * concernNum:关注的人数
 * isConcern：id所指用户是否关注其它用户 有则为1 没有则为0
 * isConcern:应用举例用户通过点击文章 文章将会访问该文章作者的id 如果访问文章的用户已经关注该文章的作者 则返回1 else 返回0
 *
 * @author zxx
 * @date 2019/5/29 17:15
 * @Effect
 */
public class Concern  implements Serializable {

    private Integer id;
    private String userName;
    private Integer concernId;
    private String concernUserName;
    private Integer concernNum;
    private Integer isConcern;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConcernUserName() {
        return concernUserName;
    }

    public void setConcernUserName(String concernUserName) {
        this.concernUserName = concernUserName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }

    public Integer getConcernNum() {
        return concernNum;
    }

    public void setConcernNum(Integer concernNum) {
        this.concernNum = concernNum;
    }

    public Integer getIsConcern() {
        return isConcern;
    }

    public void setIsConcern(Integer isConcern) {
        this.isConcern = isConcern;
    }
}
