package com.shareinfo.web;

import com.shareinfo.entity.Comment;
import com.shareinfo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2019/5/22 21:39
 * @Effect
 * @author zxx
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * user add article comment
     * URL:comment/addComment
     *
     * @param artId; : commented's article's id
     * @param commentUserId : comment's user's id
     * @param commentContent : comment's content
     *
     * @return if success upload return status:1 else status:0
     *
     */
    @RequestMapping(value = "/addComment" , method = RequestMethod.POST)
    private Map<String , Object> addComment(@RequestBody Comment comment){
        Map<String, Object> modelMap = new HashMap<String, Object>(16);
        if (commentService.addComment(comment)) {
            modelMap.put("status" , 1);
        }else {
            modelMap.put("status" , 0);
        }
        return modelMap;
    }

    /**
     * get comment by artId
     *
     * URL:comment/getCommentByArtId
     *
     * @Description get comment by artId
     * @param  artId
     * @return if dao is success return commentList
     * */
    @RequestMapping(value = "/getCommentByArtId" , method = RequestMethod.GET)
    private Map<String , Object> getCommentByArtId(Integer artId , Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Comment> comments = new ArrayList<Comment>();
        comments = commentService.getCommentByArtId(artId , id);
        modelMap.put("status",1);
        modelMap.put("data",comments);
        return modelMap;
    }

    /**
     * remove comment
     *
     * URL:comment/removeComment
     *
     * @Description get comment by artId
     * @param  commentId
     * @param  commentUserId
     * @return if dao is success return status：1
     * */
    @RequestMapping(value = "/removeComment" , method = RequestMethod.GET)
    private Map<String , Object> removeCommentBy(Integer commentId , Integer commentUserId ,Integer artId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (commentService.removeCommentByCommentId(commentId , commentUserId , artId)) {
            modelMap.put("status",1);
        }else {
            modelMap.put("status",0);
        }
        return modelMap;
    }

    /**
     * user add once like by comment id and record userId
     *
     * URL:comment/addCommentLike
     *
     * @param commentId comment's id
     * @param id user's id
     * @return if success return status : 1 else return status : 0
     */
    @RequestMapping(value = "/addCommentLike" , method = RequestMethod.GET)
    private Map<String , Object> addCommentLike(Integer commentId , Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>(12);
        if (commentService.addCommentLikeNum(commentId , id)) {
            modelMap.put("status",1);
        } else {
            modelMap.put("status",0);
        }
        return modelMap;
    }

    /**
     * delete comment like
     *
     * @param commentId comment's id
     * @param id user's id
     * @return if success return status : 1 else return status : 0
     */
    @RequestMapping(value = "/removeCommentLike" , method = RequestMethod.GET)
    private Map<String , Object> removeCommentLike(Integer commentId , Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>(12);
        if (commentService.removeCommentLike(commentId , id)) {
            modelMap.put("status",1);
        } else {
            modelMap.put("status",0);
        }
        return modelMap;
    }

//    //通过评论id获取评论的点赞数
//    @RequestMapping(value = "/getCommentLikeNumByCommentId" , method = RequestMethod.GET)
//    private Map<String , Object> getCommentLikeNumByCommentId(Integer commentId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        Integer commentLikeNum = commentService.getCommentLikeNumByCommentId(commentId);
//        modelMap.put("status",1);
//        modelMap.put("data" , commentLikeNum);
//        return modelMap;
//    }



}
