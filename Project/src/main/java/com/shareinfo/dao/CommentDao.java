package com.shareinfo.dao;

import com.shareinfo.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2019/5/22 18:03
 * @Effect 文章评论的数据库处理
 * @author zxx
 */
public interface CommentDao {

    /**
     * user add comment
     *
     * @Description user add comment
     * @param  comment comment's object
     * @return Number of items affecting the database
     * */
    Integer addComment(Comment comment);

    /**
     * get comment by artId
     *
     * @Description get comment by artId
     * @param  artId
     * @return comment's list
     * */
    List<Comment> getCommentByArtId(Integer artId);

    /**
     * get comment likeNum by commentId
     *
     * @Description get comment likeNum by commentId
     * @param  commentId
     * @return comment's like number
     * */
    Integer getCommentLikeNumByCommentId(Integer commentId);

    /**
     * remove comment likeNum by commentId
     *
     * @Description remove comment likeNum by commentId
     * @param  commentId
     * @return Number of items affecting the database
     * */
    Integer removeCommentLike(@Param("commentId") Integer commentId);

    /**
     * add comment likeNum
     *
     * @Description add comment likeNum by commentId
     * @param  commentId
     * @param id user's id
     * @return Number of items affecting the database
     * */
    Integer addCommentLike(@Param("commentId") Integer commentId , @Param("id") Integer id);

    /**
     * user delete comment by commentId
     *
     * @Description user delete comment by commentId
     * @param  commentId comment's id
     * @param  commentUserId  comment user's id
     * @param artId
     * @return Number of items affecting the database
     * */
    Integer removeCommentByCommentId(@Param("commentId") Integer commentId,@Param("commentUserId") Integer commentUserId ,@Param("artId") Integer artId);

    /**
     * getCommentUserIdByCommentId
     *
     * @param  commentId comment's id
     * @return comment's userId
     * */
    Integer getCommentUserIdByCommentId(Integer commentId);

    /**
     * getArtIdByCommentId
     *
     * @param  commentId comment's id
     * @return article's id
     * */
    Integer getArtIdByCommentId(Integer commentId);

    /**
     * check comment whether or not exist
     *
     * @param  commentId comment's id
     * @return article's id
     * */
    Integer checkCommentIsExist(@Param("commentId") Integer commentId);

    /**
     * check comment like whether or not exist
     *
     * @param  commentId comment's id
     * @param id user's id
     * @return article's id
     * */
    Integer checkCommentLikeIsExist(@Param("commentId") Integer commentId , @Param("id") Integer id);

}
