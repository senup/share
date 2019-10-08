package com.shareinfo.web;

import com.shareinfo.entity.Reply;
import com.shareinfo.service.ReplyService;
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
@RequestMapping(value = "/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    /**
     * user add reply
     * URL:/reply/addReply
     *
     * @param replyId;
     * @param  id;
     * @param replyContent;
     * @param commentId;
     * @return if success upload return status:1 else status:0
     *
     */
    @RequestMapping(value = "/addReply" , method = RequestMethod.POST)
    private Map<String , Object> addReply(@RequestBody Reply reply) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (replyService.addReply(reply)) {
            modelMap.put("status" , 1);
        } else {
            modelMap.put("status" , 0);
        }
        return modelMap;
    }

    /**
     * user add reply
     * URL:/reply/deleteReply
     *
     * @param replyId;
     * @param  id;
     * @return if success return status:1 else status:0
     *
     */
    @RequestMapping(value = "/deleteReply" , method = RequestMethod.GET)
    private Map<String , Object> deleteReply(Integer replyId , Integer id , Integer commentId) {
        System.out.println("replyId" + replyId);
        System.out.println("id" + id);
        Map<String, Object> modelMap = new HashMap<String, Object>(16);
        if (replyService.deleteReply(replyId , id , commentId)) {
            modelMap.put("status" , 1);
        }else {
            modelMap.put("status" , 0);
        }
        return modelMap;
    }

    /**
     * user add reply
     * URL:/reply/getReplyListByCommentId
     *
     * @param  commentId:comment's id
     * @return if success  return status:1 and list else status:0
     *
     */
    @RequestMapping(value = "/getReplyListByCommentId" , method = RequestMethod.GET)
    private Map<String , Object> getReplyListByCommentId(Integer commentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Reply> replies = new ArrayList<Reply>();
        replies = replyService.getReplyListByCommentId(commentId);
        modelMap.put("status" , 1);
        modelMap.put("data" , replies);
        return modelMap;
    }


}
