package com.shareinfo.dao;

import com.shareinfo.entity.Sort;
import com.shareinfo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2019/5/19 18:03
 * @Effect 文章的数据库处理
 * @author zxx
 */
public interface ArticleDao {

    /**
     * fetch data by userId
     *
     * @Description get user allArticle by userId
     * @param  id user's id
     * @return article's List
     * */
    List<Article> listUserAllArticleById(Integer id);

    /**
     *user upload article
     *
     * @Description user upload article
     * @param article article object
     * @return Number of items affecting the database
     * */
    int userUploadArticle(Article article);

    /**
     * get article sort by articleId
     *
     * @Description get article sort by articleId
     * @param artId article's id
     * @return sort
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
     * @return Number of items affecting the database
     * */
    Integer modifyArticle(Article article);

    /**
     * delete article by article id
     *
     * @Description delete article by article id
     * @param artId article's Id
     * @param id delete article's user's id to Determine whether or not you are the owner of the article
     * @return Number of items affecting the database
     * */
    Integer deleteArticleByArtId(@Param("artId") Integer artId ,@Param("id") Integer id);

    /**
     * get article visitNum by articleId
     *
     * @Description get article visitNum by articleId
     * @param artId article's id
     * @return article visit number
     * */
    Integer getArticleVisitNumByArtId(Integer artId);

    /**
     * get all article
     *
     * @param ruleId void
     * @return List<Article>
     */
    List<Article> getAllArticle();

    /**
     * add article like num
     *
     * @param artId art's id
     * @param likeId user's id
     * @return Number of items affecting the database
     */
    Integer addArticleLikeNum(@Param("artId")Integer artId , @Param("id")Integer likeId);

    /**
     * delete article like
     *
     * @param artId art's id
     * @param id user's id
     * @return Number of items affecting the database
     */
    Integer removeArticleLike(@Param("artId") Integer artId , @Param("id")Integer id);

    /**
     * count the article's like number
     *
     * @param artId art's id
     * @return Number of article's like number
     */
    Integer countArticleLikeNum(@Param("artId") Integer artId);

    /**
     * count the article's visit number
     *
     * @param artId art's id
     * @return Number of article's like number
     */
    Integer countArticleVisitNum(@Param("artId") Integer artId);

    /**
     * record What articles do user visit?
     *
     * @param artId art's id
     * @param visitId visit's user's id
     * @return Number of items affecting the database
     */
    Integer recordArticleVisit(@Param("artId") Integer artId , @Param("visitId") Integer visitId);

    /**
     * get article by artId
     *
     * @param artId article's id user's id
     * @return article
     */
    Article getArticleByArtId(@Param("artId") Integer artId);

    /**
     * get allArticle by Title
     *
     * @Description get allArticle by article's  title
     * @param title  article's title
     * @return if dao is success return articles to controller else throw error
     * */
    List<Article> getAllArticleByTitle(@Param("title") String title);

    /**
     * user input artId and userId to check the like
     *
     * @Description get allArticle by article's  title
     * @param artId article's id
     * @param id user's id
     * @return if dao is success return articles to controller else throw error
     * */
    Integer checkLikeExist(@Param("artId") Integer artId , @Param("id") Integer id);

    Integer getArticleNum(@Param("id") Integer id);

}
