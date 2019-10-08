package com.shareinfo.service;

import com.shareinfo.entity.Sort;
import com.shareinfo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  @author zxx
 * */
public interface ArticleService {

    /**
     * fetch data by userId
     *
     * @Description get user allArticle by userId
     * @param  id user's id
     * @return true:article false:status:0
     * */
    List<Article> listUserAllArticleById(Integer id);

    /**
     *user upload article
     *
     * @Description user upload article
     * @param article article object
     * @return if dao is success return true else throw error
     * */
    boolean userUploadArticle(Article article);

    /**
     * get article sort by articleId
     *
     * @Description get article sort by articleId
     * @param artId article's id
     * @return if dao is success return sorts to controller else throw error
     * */
     List<Sort> getArticleSortByAid(Integer artId);

    /**
     * get allArticle by sortId
     *
     * @Description get allArticle by sortId
     * @param sortId  sort's id
     * @return if dao is success return articles to controller else throw error
     * */
    List<Article> getAllArticleBySortId(Integer sortId);

    /**
     *
     * modify article
     *
     * @Description modify article
     * @param article article's object
     * @return if dao is success return true else throw error
     * */
    boolean modifyArticle(Article article);

    /**
     * delete article by article id
     *
     * @Description delete article by article id
     * @param artId article's Id
     * @param id delete article's user's id to Determine whether or not you are the owner of the article
     * @return if dao is success return true else throw error
     * */
    boolean deleteArticleByArtId(Integer artId , Integer id);

//    /**
//     * get article likeNum by articleId
//     *
//     * @Description get article likeNum by articleId
//     * @param artId article's id
//     * @return if dao is success return likeNum else throw error
//     * */
//    Integer getArticleLikeNumByArtId(Integer artId);

    /**
     * get all article
     *
    * @param void
    * @return List<Article>
    */
    List<Article> getAllArticle();

    /**
     * user add once like by article id and record userId
     *
     * @param artId article's id
     * @param id user's id
     * @return true or false
     */
    boolean addArticleLikeNum(@Param("artId") Integer artId ,@Param("id") Integer id);

    /**
     * user remove like and check user's id
     *
     * @param artId article's id user's id
     * @param id check userId
     * @return true or false
     */
    boolean removeArticleLike(Integer artId , Integer id);


    /**
     * user visit article and record user visit's artId
     *
     * @param artId article's id user's id
     * @param visitId visit article user's id
     * @return article
     */
    Article recordVisitAndGetArticle(Integer artId , Integer visitId);

    /**
     *
     * set article detailed info
     * @param article article object
     *
     * */
     void setArticleDetailedInfo(Article article);

    /**
     * get allArticle by Title
     *
     * @Description get allArticle by article's  title
     * @param title  article's title
     * @return if dao is success return articles to controller else throw error
     * */
     List<Article> getAllArticleByTitle(String title);

     boolean isLike(Integer artId ,Integer userId);

}
