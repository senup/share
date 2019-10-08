package com.shareinfo.dao;

import com.shareinfo.entity.Resource;

import java.util.List;

/**
 * 说明：对资源内容管理的dao层
 * 作者：tom
 */
public interface ResourceDao {


    /**
     * 功能描述: 插入资源<br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Integer
     * @Author: tom
     * @Date: 2019/7/22 9:42
     */
    Integer insertResource(Resource resource);

    /**
     * 功能描述: 删除资源<br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: java.lang.Integer
     * @Author: tom
     * @Date: 2019/7/22 9:43
     */
    Integer deleteResource(Integer resourceId);

    /**
     * 功能描述: 查找所有资源<br>
     * 〈〉
     * @Param: []
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/22 9:43
     */
    List<Resource> findAllResource();

    /**
     * 功能描述: 通过Id查找资源<br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: com.shareinfo.entity.Resource
     * @Author: tom
     * @Date: 2019/7/22 9:46
     */
    Resource findResourceById(Integer resourceId);

    /**
     * 功能描述: 通过标题查找资源<br>
     * 〈〉
     * @Param: [title]
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/22 9:43
     */
    List<Resource> findResourceByTitle(String title);

    /**
     * 功能描述: 修改资源信息<br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Integer
     * @Author: tom
     * @Date: 2019/7/22 9:43
     */
    Integer editResource(Resource resource);
}
