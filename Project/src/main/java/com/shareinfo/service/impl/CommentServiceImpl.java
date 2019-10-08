package com.shareinfo.service.impl;

import com.shareinfo.dao.ArticleDao;
import com.shareinfo.dao.UserDao;
import com.shareinfo.entity.Comment;
import com.shareinfo.dao.CommentDao;
import com.shareinfo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/5/22 21:38
 * @Effect
 * @author zxx
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
    @Autowired
    ArticleDao articleDao;
    @Autowired
    UserDao userDao;

    /**
     * user add comment
     *
     * @Description user add comment
     * @param  comment
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean addComment(Comment comment) {
        try {
            if (comment.getCommentUserId() == null){
                throw new RuntimeException("用户id不能为空！！！");
            }else if(articleDao.getArticleByArtId(comment.getArtId()) == null) {
                throw new RuntimeException("文章不存在！！！");
            }else if (userDao.findUserById(comment.getCommentUserId()) == null){
                throw new RuntimeException("用户不存在！！！");
            } else if(commentDao.addComment(comment) == 1){
                return true;
            }else if (comment.getCommentContent() == null){
                throw new RuntimeException("评论内容不能为空！！！");
            }else {
                throw new RuntimeException("未知错误！！！");
            }
        } catch (Exception e) {
            throw new RuntimeException("添加失败！！！" + e.toString());
        }
    }

    /**
     * get comment by artId
     *
     * @Description get comment by artId
     * @param  artId
     * @return if dao is success return commentNum else throw error
     * */
    @Override
    public List<Comment> getCommentByArtId(Integer artId , Integer id) {
        List<Comment> comments = new ArrayList<Comment>(16);
        if (artId == null) {
            throw new RuntimeException("文章id为空！！！" );
        }else if (articleDao.getArticleByArtId(artId) == null) {
            throw new RuntimeException("文章不存在！！！" );
        }else {
            try {
                comments = commentDao.getCommentByArtId(artId);
                if (comments != null) {
                    for (Comment comment:comments) {
                        //用户信息为空时没有赞
                        if (id == null) {
                            //判断用户是否又点赞 如果用户没有登陆 0表示没有点赞 1表示又
                            comment.setIsLike(0);
                            //判断用户是否存在 该用户是否点赞了
                        } else if (userDao.findUserById(id) != null && commentDao.checkCommentLikeIsExist(comment.getCommentId() , id) == 1) {
                            comment.setIsLike(1);
                        } else {
                            //判断用户是否又点赞 如果用户没有登陆 0表示没有点赞 1表示又
                            comment.setIsLike(0);
                        }
                        //设置点赞数
                        comment.setCommentLikeNum(commentDao.getCommentLikeNumByCommentId(comment.getCommentId()));
                    }
                    return comments;
                }else {
                    throw new RuntimeException("获取失败！！！" );
                }
            } catch (Exception e) {
                throw new RuntimeException("获取失败！！！" + e.toString());
            }
        }
    }

    /**
     * user delete comment by commentid
     *
     * @Description user delete comment by commentId
     * @param  commentId
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean removeCommentByCommentId(Integer commentId , Integer commentUserId , Integer artId) {
        if (commentId == null) {
            throw new RuntimeException("评论id为空！！！" );
        } else if (!commentDao.getCommentUserIdByCommentId(commentId).equals(commentUserId)) {
            throw new RuntimeException("非评论发起者！！！" );
        }else if (articleDao.getArticleByArtId(artId) == null) {
            throw new RuntimeException("文章不存在!!!" );
        }else if(!commentDao.getArtIdByCommentId(commentId).equals(artId)) {
            throw new RuntimeException("文章id错误!!!" );
        }else {
            try {
                Integer removeCommentNum = commentDao.removeCommentByCommentId(commentId,commentUserId,artId);
                if (removeCommentNum == 1) {
                    return true;
                }else {
                    throw new RuntimeException("获取失败！！！" );
                }
            }catch (Exception e) {
                throw new RuntimeException("删除失败！！！" + e.toString());
            }
        }
    }

    @Override
    public boolean addCommentLikeNum(Integer commentId, Integer id) {
        if(commentId == null || id  == null) {
            throw new RuntimeException("评论id或者用户id不能为空！！！");
        } else if (commentDao.checkCommentIsExist(commentId) > 0 && userDao.findUserById(id) != null && commentDao.checkCommentLikeIsExist(commentId , id) == 0) {
           //评论存在 用户存在 且该用户没有为该文章点赞 则可以点
            try {
                Integer addLikeNum = commentDao.addCommentLike(commentId , id);
                if (addLikeNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("添加失败！！！");
                }
            }catch (Exception e) {
                throw new RuntimeException("添加失败！！！" + e.toString());
            }
        } else {
            throw new RuntimeException("添加失败！！！未知异常！！！");
        }
    }

    @Override
    public boolean removeCommentLike(Integer commentId, Integer id) {
        if(commentId == null || id  == null) {
            throw new RuntimeException("评论id或者用户id不能为空！！！");
        } else if (commentDao.checkCommentLikeIsExist(commentId , id) == 1) {
            try {
                Integer removeLikeNum = commentDao.removeCommentLike(commentId);
                if (removeLikeNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("取消赞失败！！！");
                }
            }catch (Exception e) {
                throw new RuntimeException("取消赞失败！！！" + e.toString());
            }
        }else {
            throw new RuntimeException("取消赞失败！！！未考虑到的错误！！！");
        }
    }

    /**
     * get comment likeNum by commentId
     *
     * @Description get comment likeNum by commentId
     * @param  commentId
     * @return if dao is success return LikeNum else throw error
     * */
    @Override
    public Integer getCommentLikeNumByCommentId(Integer commentId) {
        if (commentId == null) {
            throw new RuntimeException("文章id为空！！！" );
        } else {
            try {
                Integer commentLikeNum = commentDao.getCommentLikeNumByCommentId(commentId);
                return commentLikeNum;
            }catch (Exception e) {
                throw new RuntimeException("获取失败！！！" + e.toString());
            }
        }
    }

}
