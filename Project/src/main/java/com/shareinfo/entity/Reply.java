package com.shareinfo.entity;

import java.io.Serializable;

/**
 * @date 2019/5/22 17:55
 * @Effect : 回复评论的实体类
 * @author zxx
 */
public class Reply implements Serializable {

    Integer replyId;
    Integer id;
    String replyContent;
    Integer replyLikeNum;
    String time;
    Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyLikeNum() {
        return replyLikeNum;
    }

    public void setReplyLikeNum(Integer replyLikeNum) {
        this.replyLikeNum = replyLikeNum;
    }
}
