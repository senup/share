package com.shareinfo.service;

import com.shareinfo.entity.Comment;

import java.util.List;

/**
 * @date 2019/5/22 21:37
 * @Effect
 * @author zxx
 */
public interface CommentService {

    /**
     * user add comment
     *
     * @Description user add comment
     * @param  comment comment's object
     * @return if dao is success return true else throw error
     * */
    boolean addComment(Comment comment);

    /**
     * get comment by artId
     *
     * @Description get comment by artId
     * @param  artId
     * @return if dao is success return commentNum else throw error
     * */
    List<Comment> getCommentByArtId(Integer artId , Integer id);

    /**
     * get comment likeNum by commentId
     *
     * @Description get comment likeNum by commentId
     * @param  commentId
     * @return if dao is success return LikeNum else throw error
     * */
    Integer getCommentLikeNumByCommentId(Integer commentId);

    /**
     * user delete comment by commentId
     *
     * @Description user delete comment by commentId
     * @param  commentId comment's id
     * @param commentUserId
     * @param artId
     * @return if dao is success return true else throw error
     * */
    boolean removeCommentByCommentId(Integer commentId , Integer commentUserId , Integer artId);

    /**
     * user add once like by comment id and record userId
     *
     * @param commentId comment's id
     * @param id user's id
     * @return true or false
     */
    boolean addCommentLikeNum(Integer commentId , Integer id);

    /**
     * user remove like and check user's id
     *
     * @param commentId comment's id user's id
     * @param id check userId
     * @return true or false
     */
    boolean removeCommentLike(Integer commentId , Integer id);

}
