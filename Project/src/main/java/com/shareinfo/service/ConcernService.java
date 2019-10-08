package com.shareinfo.service;

import com.shareinfo.entity.Concern;

import java.util.List;

/**
 * @date 2019/5/29 18:11
 * @Effect
 */
public interface ConcernService {

    /**
     * 关注其它的用户
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    boolean concernOtherPerson(Integer id , Integer concernId);

    /**
     * 取消关注其它的用户
     *
     * @param id 关注者的id
     * @param concernId  被关注者的id
     * @return true or false
     */
    boolean cancelConcernOtherPerson(Integer id , Integer concernId);

    /**
     * 获取id号对应的用户其关注的其它用户
     *
     * @param id 关注者的id
     * @param concernId 被关注者的id
     * @return true or false
     */
    List<Concern> getAllConcernById(Integer id , Integer concernId);

    /**
     * 获取关注id的人有多少人
     *
     * @param id 关注者的id
     * @return 关注的数目
     */
    Integer[] getConcernNumAndArticleNum(Integer id);

    /**
     * id是否关注concernedId
     *
     * @param id 关注者的id
     * @param concernId  被关注者id
     * @return 关注的数目
     */
    boolean isConcern(Integer id , Integer concernId);

}
