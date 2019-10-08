package com.shareinfo.service.impl;

import com.shareinfo.dao.CommentDao;
import com.shareinfo.dao.UserDao;
import com.shareinfo.entity.Reply;
import com.shareinfo.dao.ReplyDao;
import com.shareinfo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/5/22 21:38
 * @Effect
 * @author zxx
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;

    /**
     * add comment's Reply
     *
     * @Description add comment's Reply
     * @param Reply
     * @param commentId reply comment's id
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean addReply(@RequestBody Reply reply) {
        if (reply.getId() == null || reply.getReplyContent() == null || reply.getCommentId() == null) {
            throw new RuntimeException("必要信息不能为空！！！");
        } else if (commentDao.checkCommentIsExist(reply.getCommentId()) > 0 && userDao.findUserById(reply.getId()) != null) {
            try {
                Integer addReplyNum = replyDao.addReply(reply);
                if (addReplyNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("回复评论失败！！！");
                }
            }catch (Exception e) {
                throw new RuntimeException("回复评论失败！！！" + e.toString() );
            }
        } else {
            throw new RuntimeException("回复评论失败！！！" + " 未考虑到的异常！！！");
        }
    }

    /**
     * get comment's replyList by commentId
     *
     * @Description get comment's replyList by commentId
     * @param commentId
     * @return if dao is success return ReplyList else throw error
     * */
    @Override
    public List<Reply> getReplyListByCommentId(Integer commentId) {
        List<Reply> replies = new ArrayList<Reply>();
        if (commentId == null) {
            throw new RuntimeException("commentId不能为空");
        } else {
            try {
                replies = replyDao.getReplyListByCommentId(commentId);
                if (replies == null) {
                    throw new RuntimeException("获取失败！！！");
                } else {
                    return replies;
                }
            }catch (Exception e) {
                throw new RuntimeException("获取失败！！！" + e.toString());
            }
        }
    }

    /**
     * delete comment's Reply
     *
     * @Description delete comment's Reply
     * @param ReplyId
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean deleteReply(Integer replyId , Integer id ,Integer commentId) {
        if (replyId == null || id == null || commentId == null) {
            throw new RuntimeException("ReplyId为空!!!!或用户id为空！！！");
        } else if (replyDao.checkReplyIsExist(replyId , id , commentId) > 0) {
            try {
                Integer deleteNum = replyDao.deleteReply(replyId , id);
                if (deleteNum == 1) {
                    return true;
                } else if (deleteNum > 1){
                    throw new RuntimeException("删除超过1条回复！！！ 检查数据库文件！！！");
                }else {
                    throw new RuntimeException("删除失败！！！");
                }
            }catch (Exception e) {
                throw new RuntimeException("删除回复失败！！！" + e.toString());
            }
        }else if  (replyDao.checkReplyIsExist(replyId , id , commentId) == 0) {
            throw new RuntimeException("该回复不存在！！！" );
        } else {
            throw new RuntimeException("删除回复失败！！！" + "未考虑到的错误！！！");
        }
    }

    @Override
    public boolean addReplyLikeNum(Integer replyId, Integer id) {
        return false;
    }

    @Override
    public boolean removeReplyLike(Integer replyId, Integer id) {
        return false;
    }
}
