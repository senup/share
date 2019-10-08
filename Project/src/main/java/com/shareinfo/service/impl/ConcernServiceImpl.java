package com.shareinfo.service.impl;

import com.shareinfo.dao.ArticleDao;
import com.shareinfo.dao.ConcernDao;
import com.shareinfo.entity.Concern;
import com.shareinfo.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxx
 * @date 2019/5/29 18:43
 * @Effect
 */
@Service
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    ConcernDao concernDao;
    @Autowired
    ArticleDao articleDao;

    /**
     * 关注其它的用户
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    @Override
    public boolean concernOtherPerson(Integer id, Integer concernId) {
        try {
            Integer concernNum = concernDao.insertConcern(id , concernId);
            if (concernNum == 1) {
                return true;
            }else {
                throw new RuntimeException("数据库插入条数有问题！！！ 请检查数据库！！！" );
            }
        }catch (Exception e){
            throw new RuntimeException("关注失败！！！" + e.toString());
        }
    }

    /**
     * 取消关注其它的用户
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    @Override
    public boolean cancelConcernOtherPerson(Integer id, Integer concernId) {
        try {
            Integer cancelConcernNum = concernDao.deleteConcern(id , concernId);
            if (cancelConcernNum == 1) {
                return true;
            }else {
                throw new RuntimeException("数据库删除条数有问题！！！ 请检查数据库！！！" );
            }
        }catch (Exception e){
            throw new RuntimeException("取消关注失败！！！" + e.toString());
        }
    }

    /**
     * 获取id号被关注情况
     *
     * @param id 关注者的id
     * @param concernId 被关注者的id
     * @return true or false
     */
    @Override
    public List<Concern> getAllConcernById(Integer id , Integer concernId) {
//        List<Concern> concerns = new ArrayList<Concern>();
//        concerns = concernDao.getAllConcernById(concernId);
//        for (Concern concern:concerns) {
//            //获取id对应的用户的被关注数目
//            concern.setConcernNum(concernId);
//            //判断是否关注该用户
//            concern.setIsConcern(concernDao.isConcernOtherPeople(id, concernId));
//        }
//        return concerns;
//    }
        return null;
    }

    /**
     * 获取关注id的人有多少人
     *
     * @param id 关注者的id
     * @return 关注的数目
     */
    @Override
    public Integer[] getConcernNumAndArticleNum(Integer id) {
        Integer[] num = new Integer[2];
        num[0] = concernDao.getUserConcernedNum(id);
        num[1] = articleDao.getArticleNum(id);
        return num;
    }

    @Override
    public boolean isConcern(Integer id, Integer concernId) {
        if (concernDao.isConcernOtherPeople(id , concernId) == 1) {
            return true;
        } else {
            throw new RuntimeException("未关注！！！");
        }
    }

}
