package com.shareinfo.entity;

import java.io.Serializable;

/**
 * @author zxx
 * @Edit time
 * @artid : 文章的id
 * @id : 用户的id
 * @sortid : 类别的id
 * @sortName : 分类的名字
 * @title : 文章标题
 * @content ： 文章实体
 * @isLike ： 判断用户是否点赞
 * @articleLikeNum : 文章点赞数
 * @articleVisitNum ：文章访问量
 */

public class Article implements Serializable {

    private Integer artId;
    private Integer id;
    private Integer sortId;
    private String title;
    private String content;
    private String time;
    private Integer articleLikeNum;
    private Integer articleVisitNum;
    private String userName;
    private String sortName;
    private Integer isLike;

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getArticleLikeNum() {
        return articleLikeNum;
    }

    public void setArticleLikeNum(Integer articleLikeNum) {
        this.articleLikeNum = articleLikeNum;
    }

    public Integer getArticleVisitNum() {
        return articleVisitNum;
    }

    public void setArticleVisitNum(Integer articleVisitNum) {
        this.articleVisitNum = articleVisitNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
