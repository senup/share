package com.shareinfo.dao;

import com.shareinfo.entity.Concern;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 对用户关注的数据库操作
 *
 * @author zxx
 * @date 2019/5/29 17:36
 * @Effect
 */
public interface ConcernDao {

    /**
     *
     * 插入关注信息
     *
     * @param id 用户
     * @param concernId 被关注的用户信息
     * @return 返回插入的条数 正常插入应该只有一条
     * @author zxx
     * @date 2019/5/29 17:36
     */
    Integer insertConcern(@Param("id") Integer id ,@Param("concernId") Integer concernId);
    /**
     *
     * 删除关注信息
     *
     * @param id 用户
     * @param concernId 被关注的用户信息
     * @return 返回插入的条数 正常删除应该只有一条
     * @author zxx
     * @date 2019/5/29 17:36
     */
    Integer deleteConcern(@Param("id") Integer id ,@Param("concernId") Integer concernId);
    /**
     *
     * 获取某一用户的所有关注信息
     *
     * @param id 用户信息
     * @return 返回插入的条数 正常删除应该只有一条
     * @author zxx
     * @date 2019/5/29 17:36
     */
    List<Concern> getAllConcernById(Integer id);

    /**
     *
     * 获取某一用户被关注的数量
     *
     * @param id 用户信息
     * @return 返回被关注的数量
     * @author zxx
     * @date 2019/5/29 17:36
     */
    Integer getUserConcernedNum(Integer id);

    /**
     *
     * 某一用户是否关注另外一个用户 一个关注返回查询条数 正常只有1
     *
     * @param id 用户
     * @param ConcernId 被关注的用户信息
     * @return 返回插入的条数 正常删除应该只有一条
     * @author zxx
     * @date 2019/5/29 17:36
     */
    Integer isConcernOtherPeople(@Param("id") Integer id ,@Param("concernId") Integer ConcernId);

}
