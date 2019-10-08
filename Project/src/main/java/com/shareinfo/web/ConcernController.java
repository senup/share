package com.shareinfo.web;

import com.shareinfo.entity.Article;
import com.shareinfo.entity.Concern;
import com.shareinfo.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @date 2019/5/29 19:26
 * @Effect
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/concern")
public class ConcernController {

    @Autowired
    ConcernService concernService;

    /**
     * 关注其它的用户
     *
     * URL:concern/concernOtherPerson
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    @RequestMapping(value = "/concernOtherPerson")
    private Map<String , Object> concernOtherPerson(Integer id , Integer concernId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (concernService.concernOtherPerson(id , concernId)) {
            modelMap.put("status" , 1);
        } else {
            modelMap.put("status" , 0);
        }
        return modelMap;
    }

    /**
     * 取消关注其它的用户
     *
     * URL:concern/cancelConcernOtherPerson
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    @RequestMapping(value = "/cancelConcernOtherPerson")
    private Map<String , Object>  cancelConcernOtherPerson(Integer id , Integer concernId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (concernService.cancelConcernOtherPerson(id , concernId)){
            modelMap.put("status" , 1);
        }else {
            modelMap.put("status" , 1);
        }
        return modelMap;
    }

//    /**
//     * 通过id号被关注情况
//     *
//     * URL:concern/getAllConcern
//     *
//     * @param id 关注者的id
//     * @return true or false
//     */
//    @RequestMapping(value = "/getAllConcern")
//    private Map<String , Object> getAllConcern(Integer id , Integer concernId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<Concern> concerns = concernService.getAllConcernById(id , concernId);
//        if (concerns != null) {
//            modelMap.put("status" , 1);
//            modelMap.put("data" , concerns);
//        }else {
//            modelMap.put("status" , 0);
//        }
//        return modelMap;
//    }

    /**
     * 获取关注id的人有多少人
     *
     * URL:concern/getConcernNum
     *
     * @return num
     */
    @RequestMapping(value = "/getConcernNum")
    private Map<String , Object>  getConcernNum(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Integer[] num = concernService.getConcernNumAndArticleNum(id);
        modelMap.put("status" , 1);
        modelMap.put("concernNum",num[0]);
        modelMap.put("articleNum",num[1]);
        return modelMap;
    }

    /**
     * 判断id对应的用户是否关注concernedId对应的用户
     *
     * URL:concern/isConcern
     *
     * @return num
     */
    @RequestMapping(value = "/isConcern")
    private Map<String , Object> isConcern(Integer id , Integer concernId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (concernService.isConcern(id, concernId)) {
            modelMap.put("status" , 1);
        }else {
            modelMap.put("status" , 0);
        }
        return modelMap;
    }

}
