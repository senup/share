package com.shareinfo.web;

import com.shareinfo.entity.Article;
import com.shareinfo.entity.Sort;
import com.shareinfo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2019/5/16 21:58
 * @author zxx
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * get all article list
     * URL:article/getAllArticle
     *
     * @return if success return status:1 and article's list else status:0
     *
     */
    @RequestMapping(value = "/getAllArticle")
    private Map<String , Object> getAllArticle() {
        System.out.println("okokokokokokokok!!!!");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> articles = articleService.getAllArticle();
        modelMap.put("status" , 1);
        modelMap.put("data" , articles);
        return modelMap;
    }

    /**
     * get all article list by title
     * URL:article/getAllArticleByTitle
     *
     * @return if success return status:1 and article's list else status:0
     *
     */
    @RequestMapping(value = "/getAllArticleByTitle")
    private Map<String , Object> getAllArticleByTitle(String title) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> articles = articleService.getAllArticleByTitle(title);
        modelMap.put("status" , 1);
        modelMap.put("data" , articles);
        return modelMap;
    }

    /**
     * user upload article
     * URL:article/userUploadArticle
     *
     * @param id : user's id
     * @param content article's content
     * @param title article's title
     * @param sortId article's sort's id
     * @return if success upload return status:1 else status:0
     *
     */
    @RequestMapping(value = "/userUploadArticle" , method = RequestMethod.POST)
    private Map<String , Object> userUploadArticle(@RequestBody Article article) {
        Map<String, Object> modelMap = new HashMap<String, Object>(16);
        if (articleService.userUploadArticle(article)) {
            modelMap.put("status" , 1);
            return modelMap;
        } else {
            throw new RuntimeException("error!!!");
        }
    }

    /**
     * user delete article by artId and userId
     * URL:article/deleteArticleByArtId
     *
     * @param id delete article's user's id to Determine whether or not you are the owner of the article
     * @param artId delete's article's id
     *
     * @return if success delete return status:1 else status:0
     *
     */
    @RequestMapping(value = "/deleteArticleByArtId" , method = RequestMethod.GET)
    private Map<String , Object> deleteArticleByArtId(Integer artId , Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (articleService.deleteArticleByArtId(artId , id)){
            modelMap.put("status" , 1);
            return modelMap;
        } else {
            throw new RuntimeException("controller出错！！！");
        }
    }

    /**
     * user modify article
     * URL:article/modifyArticle
     *
     * @param artId : article's id
     * @param id : user's id
     * @param content article's content
     * @param title article's title
     * @param sortId article's sort's id,
     * @return if success modify article return status:1 else status:0
     *
     */
    @RequestMapping(value = "/modifyArticle" , method = RequestMethod.POST)
    private Map<String , Object> modifyArticle(@RequestBody Article article) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (articleService.modifyArticle(article)){
            modelMap.put("status" , 1);
            return modelMap;
        } else {
            throw new RuntimeException("controller出错！！！");
        }
    }

    /**
     *
     * list user all article by user's id
     * URL:article/listUserAllArticleById
     *
     * @param id user's id
     * @return if success return status:1 and article's list else return status : 0
     *
     */
    @RequestMapping(value = "/listUserAllArticleById" , method = RequestMethod.GET)
    private Map<String , Object> listUserAllArticleById(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>(16);
        List<Article> list = new ArrayList<Article>();
        // 获取用户文章信息
        list = articleService.listUserAllArticleById(id);
        //service已经将list为空的情况排除
        modelMap.put("status" , 1);
        modelMap.put("data" , list);
        return modelMap;
    }

    /**
     *
     * user visit article by article's id and record visit article's user' id
     *URL:article/visitArticle
     *
     * @param artId article's id
     * @param visitId visit's user's id
     * @return if success return status:1 and article else return status : 0
     *
     */
    @RequestMapping(value = "/visitArticle" , method = RequestMethod.GET)
    private Map<String , Object> visitArticle(String artId , String visitId) {
        try {
            Map<String, Object> modelMap = new HashMap<String, Object>();
            //没有登陆的用户自动记为-1 且不记访问量
            if (visitId == null) {
                visitId = "-1";
            }
            //如果输入类型不是整数 直接抛出异常
            Article a = articleService.recordVisitAndGetArticle(Integer.valueOf(artId) ,Integer.valueOf(visitId));
            modelMap.put("status" , 1);
            modelMap.put("data" , a);
            return modelMap;
        }catch (Exception e) {
            throw new RuntimeException("用户输入数据有误！！！" + e.toString());
        }
    }

    /**
     *
     * get some article by sortId
     *URL:article/getAllArticleBySortId
     *
     * @param sortId sort's id
     *
     * @return if success return status:1 and article else return status : 0
     *
     */
    @RequestMapping(value = "/getAllArticleBySortId" , method = RequestMethod.GET)
    private Map<String , Object> getAllArticleBySortId(Integer sortId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> articles = new ArrayList<Article>(12);
        articles = articleService.getAllArticleBySortId(sortId);
        modelMap.put("status" , 1);
        modelMap.put("data" , articles);
        return modelMap;
    }


    /**
     * user add once like by article id and record userId
     *
     * userId and artId must exist
     *
     * URL:article/addArticleLikeNum
     *
     * @param artId article's id
     * @param id user's id
     * @return if success return status : 1 else return status : 0
     */
    @RequestMapping(value = "/addArticleLikeNum" , method = RequestMethod.GET)
    private Map<String , Object> addArticleLikeNum(Integer artId , Integer id) {
        System.out.println("artId is " + artId);
        System.out.println("Id is " + id);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(articleService.addArticleLikeNum(artId , id)) {
            modelMap.put("status" , 1);
            return modelMap;
        }else {
            modelMap.put("status" , 0);
            return modelMap;
        }
    }

    /**
     * user add once like by article id and record userId
     *
     * userId and artId must exist
     * URL:article/removeArticleLike
     *
     * @param artId article's id
     * @param id user's id check Whether the user is the like master
     * @return if success return status : 1 else return status : 0
     */
    @RequestMapping(value = "/removeArticleLike" , method = RequestMethod.GET)
    private Map<String , Object> removeArticleLike(Integer artId , Integer id) {
        System.out.println("artId is " + artId);
        System.out.println("Id is " + id);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(articleService.removeArticleLike(artId , id)) {
            modelMap.put("status" , 1);
            return modelMap;
        }else {
            modelMap.put("status" , 0);
            return modelMap;
        }
    }

//    /**
//     * @Effect : 根据文章id 获取文章类别
//     * @return : 成功返回状态码1 失败状态码0
//     */
//    @RequestMapping(value = "/getArticleSortByAid" , method = RequestMethod.GET)
//    private Map<String , Object> getArticleSortByAid(Integer artid) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<Sort> articleSort = new ArrayList<Sort>();
//        articleSort = articleService.getArticleSortByAid(artid);
//        modelMap.put("status" , 1);
//        modelMap.put("data" , articleSort);
//        return modelMap;
//    }

//    //根据文章id获取点赞数
//    @RequestMapping(value = "/getArticleLikeNumByArtId" , method = RequestMethod.GET)
//    private Map<String , Object> getArticleLikeNumByArtId(Integer artId){
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        Integer likeNum = articleService.getArticleLikeNumByArtId(artId);
//        modelMap.put("status" , 1);
//        modelMap.put("data" , likeNum);
//        return modelMap;
//    }
//
//    // 根据文章id获取访问量
//    @RequestMapping(value = "/getArticleVisitNumByArtId" , method = RequestMethod.GET)
//    private Map<String , Object> getArticleVisitNumByArtId(Integer artId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        Integer visitNum = 0;
//        modelMap.put("status" , 1);
//        modelMap.put("data" , visitNum);
//        return modelMap;
//    }

}
