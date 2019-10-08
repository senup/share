package com.shareinfo.service;

import com.shareinfo.entity.Reply;

import java.util.List;

/**
 * @date 2019/5/22 21:38
 * @Effect
 * @author zxx
 */
public interface ReplyService {

    /**
     * add comment's Reply
     *
     * @Description add comment's Reply
     * @param reply reply's object
     * @return if dao is success return true else throw error
     * */
    boolean addReply(Reply reply);

    /**
     * get comment's replyList by commentId
     *
     * @Description get comment's replyList by commentId
     * @param commentId
     * @return if dao is success return ReplyList else throw error
     * */
    List<Reply> getReplyListByCommentId(Integer commentId);

    /**
     * delete comment's Reply
     *
     * @Description delete comment's Reply
     * @param replyId reply's id
     * @param id reply's user's id
     * @return if dao is success return true else throw error
     * */
    boolean deleteReply(Integer replyId , Integer id ,Integer commentId);

    /**
     * user add once like by article id and record userId
     *
     * @param replyId Reply's id
     * @param id user's id
     * @return true or false
     */
    boolean addReplyLikeNum(Integer replyId , Integer id);

    /**
     * user remove like and check user's id
     *
     * @param replyId Reply's id
     * @param id check userId
     * @return true or false
     */
    boolean removeReplyLike(Integer replyId , Integer id);

}
