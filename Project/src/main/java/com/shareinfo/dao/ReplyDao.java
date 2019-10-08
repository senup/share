package com.shareinfo.dao;

import com.shareinfo.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2019/5/22 18:04
 * @Effect 回复评论的数据库处理
 * @author zxx
 */
public interface ReplyDao {

    /**
     * add comment's Reply
     *
     * @Description add comment's Reply
     * @param reply reply's object
     * @return Number of items affecting the database
     * */
    Integer addReply(Reply reply);

    /**
     * get comment's replyList by commentId
     *
     * @Description get comment's replyList by commentId
     * @param commentId
     * @return reply's list
     * */
    List<Reply> getReplyListByCommentId(Integer commentId);

    /**
     * delete comment's Reply
     *
     * @Description delete comment's Reply
     * @param replyId reply's id
     * @param id user's id
     * @return Number of items affecting the database
     * */
    Integer deleteReply(@Param("replyId") Integer replyId , @Param("id") Integer id);

    /**
     * get comment likeNum by commentId
     *
     * @Description get comment likeNum by commentId
     * @param  replyId
     * @return comment's like number
     * */
    Integer getReplyLikeNumByCommentId(Integer replyId);

    /**
     * remove comment likeNum by commentId
     *
     * @Description remove comment likeNum by commentId
     * @param  replyId
     * @param  id user's id
     * @return Number of items affecting the database
     * */
    Integer removeReplyLike(@Param("replyId") Integer replyId ,@Param("id") Integer id);

    /**
     * check reply whether or not exist
     *
     * @param  replyId reply's id
     * @param id user's id
     * @return article's id
     * */
    Integer checkReplyIsExist(@Param("replyId") Integer replyId , @Param("id") Integer id , @Param("commentId") Integer commentId);

}
