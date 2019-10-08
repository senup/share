package com.shareinfo.service.impl;

import com.shareinfo.dao.SortDao;
import com.shareinfo.entity.Sort;
import com.shareinfo.dao.UserDao;
import com.shareinfo.entity.Article;
import com.shareinfo.dao.ArticleDao;
import com.shareinfo.entity.User;
import com.shareinfo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxx
 * @date 2019/5/16 21:45
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    UserDao userDao;
    @Autowired
    SortDao sortDao;

    /**
     * user visit article and record user visit's artId
     *
     * @param artId article's id user's id
     * @param visitId visit's userId
     * @return article
     */
    @Override
    public Article recordVisitAndGetArticle(Integer artId , Integer visitId) {
        try {
            //获取文章
            Article article = articleDao.getArticleByArtId(artId);
            //判断用户是否点赞
            if (articleDao.checkLikeExist(artId,visitId) == 1) {
                article.setIsLike(1);
            }else {
                article.setIsLike(0);
            }
            //如果用户已经访问过 数据库将会报错 所以需要try catch
            try {
                //用户id为-1 时表示没有登陆就访问
                if (visitId != -1) {
                    //判断用户是否点赞 有就为1 没有就为0
                    //将用户的id 以及文章的id记录下来 记录用户访问的文章
                    //如果用户没有登陆 无法增加访问量
                    Integer insertNum = articleDao.recordArticleVisit(artId , visitId);
                    if (insertNum == 1) {
                        System.out.println("访问量+1！！！");
                    }
                }else {
                    //用户没有登陆 没有赞
                    article.setIsLike(0);
                }
            }catch (Exception e) {
                //如果用户今天访问过 因为数据库会产生插入异常 所以将会抛出异常
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                System.out.println("该用户在今天已经访问过该文章！！！");
            } finally {
                if (artId == null) {
                    throw new RuntimeException("文章id不能为空！！！");
                } else {
                    this.setArticleDetailedInfo(article);
                    return article;
                }
            }
        }catch (Exception e) {
            throw new RuntimeException("数据库出错！！！" + e.toString());
        }
    }

    /**
     * @Description user upload article
     * @param article
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean userUploadArticle(Article article) {

        try {
            //用户插入数据库的数目
            Integer insertDatabaseNum = articleDao.userUploadArticle(article);
            if (article.getId() == null || article.getArtId() == null) {
                throw new RuntimeException("用户id或者文章id为空！！！");
            } else if (insertDatabaseNum < 1){
                throw new RuntimeException("数据库出错！！！");
            } else if (userDao.findUserById(article.getId() ) == null || articleDao.getArticleByArtId(article.getArtId()) == null) {
                throw new RuntimeException("用户id或者文章id不存在！！！");
            } else if (insertDatabaseNum == 1){
                return true;
            }else {
                throw new RuntimeException("未知错误！！！");
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库出错！！！" + e.toString());
        }

    }

    @Override
    public List<Sort> getArticleSortByAid(Integer artId) {
        return null;
    }

    /**
     * @Description delete article by article id
     * @param artId
     * @param id delete article's user's id to Determine whether or not you are the owner of the article
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean deleteArticleByArtId(Integer artId , Integer id) {
        if (artId == null) {
            throw new RuntimeException("文章id为空");
        } else {
            try {
               if (artId == null || id == null) {
                   throw new RuntimeException("文章id或用户id为空");
               } else {
                   //数据库修改的条数
                   int effectedNum = articleDao.deleteArticleByArtId(artId , id);
                   if (effectedNum == 1) {
                       return true;
                   } else {
                       throw new RuntimeException("数据库删除失败！！！可能该文章不存在！！！");
                   }
               }
            }catch (Exception e) {
                throw new RuntimeException("数据库删除失败！！！" + e.toString());
            }
        }
    }

    /**
     * @Description get user allArticle by userId
     * @param  id
     * @return true:article false:status:0
     * */
    @Override
    public List<Article> listUserAllArticleById(Integer id) {
        try {
            if (userDao.findUserById(id) == null) {
                throw new RuntimeException("该用户不存在！！！");
            } else {
                List<Article> articles = new ArrayList<Article>();
                articles = articleDao.listUserAllArticleById(id);
                if (articles.isEmpty()) {
                    throw new RuntimeException("该用户没有文章");
                }else {
                    for (Article article:articles) {
                        this.setArticleDetailedInfo(article);
                    }
                    return articles;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("存在异常" + e.toString());
        }
    }

    /**
     * @Description get allArticle by sortId
     * @param sortId
     * @return if dao is success return articles to controller else throw error
     * */
    @Override
    public List<Article> getAllArticleBySortId(Integer sortId) {
        List<Article> articles = articleDao.getAllArticleBySortId(sortId);
        if (articles != null) {
            for (Article article:articles) {
                //设置文章详细数据
                this.setArticleDetailedInfo(article);
            }
            return articles;
        } else {
            throw new RuntimeException("该类无文章存在！！！");
        }
    }

    /**
     * get articleList
     *
     * @Description get articleList
     * @return if dao is success return articleList else throw error
     * */
    @Override
    public List<Article> getAllArticle() {
        try {
            List<Article> articles = articleDao.getAllArticle();
            if (articles.isEmpty()) {
                throw new RuntimeException("获取数据失败！！！");
            }else {
                for (Article article:articles){
                    this.setArticleDetailedInfo(article);
                }
                return articles;
            }
        }catch (Exception e) {
            throw new RuntimeException("数据库异常！！！" + e.toString());
        }

    }

    /**
     * get allArticle by Title
     *
     * @Description get allArticle by article's  title
     * @param title  article's title
     * @return if dao is success return articles to controller else throw error
     * */
    @Override
    public List<Article> getAllArticleByTitle(String title) {
        try {
            List<Article> articles = articleDao.getAllArticleByTitle(title);
            if (articles.isEmpty()) {
                throw new RuntimeException("获取数据为空！！！");
            }else {
                for (Article article:articles){
                    this.setArticleDetailedInfo(article);
                }
                return articles;
            }
        }catch (Exception e) {
            throw new RuntimeException("数据库异常！！！" + e.toString());
        }
    }

    @Override
    public boolean isLike(Integer artId, Integer userId) {
        return false;
    }

//    /**
//     * @Description get article sort by articleId
//     * @param artId
//     * @return if dao is success return sorts to controller else throw error
//     * */
//    @Override
//    public List<Sort> getArticleSortByAid(Integer artId) {
//        List<Sort> sorts = articleDao.getArticleSortByAid(artId);
//        if (sorts.isEmpty()) {
//            throw new RuntimeException("该分类无文章！！！");
//        } else {
//            return sorts;
//        }
//    }



    /**
     * modify article
     *
     * @Description modify article
     * @param article
     * @return if dao is success return true else throw error
     * */
    @Override
    public boolean modifyArticle(Article article) {
        if (article.getArtId() == null) {
            throw new RuntimeException("文章id不能为空！！！");
        }else if (!(articleDao.getArticleByArtId(article.getArtId()).getId().equals(article.getId()))){
            //判断修改文章的用户是否为文章的主人
            throw new RuntimeException("非文章所有者！！！");
        }else {
            //抛出数据库异常
            try {
                if (articleDao.getArticleByArtId(article.getArtId()) != null) {
                    //数据库修改的条数
                    int effectedNum = articleDao.modifyArticle(article);
                    if (effectedNum == 1) {
                        return true;
                    } else {
                        throw new RuntimeException("文章修改失败！！！");
                    }
                } else {
                    throw new RuntimeException("文章不存在！！！");
                }
            }catch (Exception e) {
                throw new RuntimeException("文章修改失败！！！" + e.toString());
            }
        }
    }

    /**
     * user add once like by article id and record userId
     *
     * userId and artId must exist
     *
     * @param artId article's id
     * @param id user's id
     * @return true or false
     */
    @Override
    public boolean addArticleLikeNum(Integer artId, Integer id) {
        try {
            if (articleDao.getArticleByArtId(artId) == null || artId == null) {
                throw new RuntimeException("文章不存在 无法点赞");
            }else if (userDao.findUserById(id) == null || id == null){
                throw new RuntimeException("用户不存在 无法点赞");
            }else {
                Integer addLikeNum = articleDao.addArticleLikeNum(artId , id);
                if(addLikeNum == 1) {
                    articleDao.getArticleByArtId(artId).setIsLike(1);
                    return true;
                }else {
                    return false;
                }
            }

        }catch (Exception e) {
            throw new RuntimeException("数据库插入异常！！！" + e.toString());
        }
    }

    /**
     * user add once like by article id and record userId
     *
     * userId and artId must exist
     *
     * @param artId article's id
     * @param id user's id check Whether the user is the like master
     * @return true or false
     */
    @Override
    public boolean removeArticleLike(Integer artId, Integer id) {
        try {
            Integer removeLikeNum = articleDao.removeArticleLike(artId , id);
            if (removeLikeNum == 1) {
                articleDao.getArticleByArtId(artId).setIsLike(0);
                return true;
            }else {
                throw new RuntimeException("该赞不存在！！！");
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库异常！！！" + e.toString());
        }
    }

    /**
     *
     * set article detailed info
     *
     * */
    @Override
    public void setArticleDetailedInfo(Article article) {
        if (article != null) {
            //设置文章点赞数
            article.setArticleLikeNum(articleDao.countArticleLikeNum(article.getArtId()));
            //设置文章访问量
            article.setArticleVisitNum(articleDao.countArticleVisitNum(article.getArtId()));
        }
    }

//    /**
//     * @Description get article likeNum by articleid
//     * @param artId
//     * @return if dao is success return likeNum else throw error
//     * */
//    @Override
//    public Integer getArticleLikeNumByArtId(Integer artId) {
//        if (artId == null) {
//            throw new RuntimeException("文章id不能为空！！！");
//        } else {
//            try {
//                Integer likeNum = articleDao.countArticleLikeNum(artId);
//                return likeNum;
//            } catch (Exception e) {
//                throw new RuntimeException("数据库异常！！！" + e.toString());
//            }
//        }
//    }

}
