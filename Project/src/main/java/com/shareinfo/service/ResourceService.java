package com.shareinfo.service;

import com.shareinfo.entity.Resource;

import java.util.List;

/**
 * 功能描述: <br>
 * 〈〉
 * @Param:
 * @Return:
 * @Author: tom
 * @Date: 2019/7/22 10:07
 */
public interface ResourceService {
    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Integer
     * @Author: tom
     * @Date: 2019/7/22 10:10
     */
    Boolean insertResource(Resource resource);
    
    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: []
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/23 20:16
     */
    List<Resource> findAllResource();
    
    
    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: com.shareinfo.entity.Resource
     * @Author: tom
     * @Date: 2019/7/23 20:16
     */
    Resource findResourceById(Integer resourceId);

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceTitle]
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/23 20:16
     */
    List<Resource> findResourceByTitle(String resourceTitle);

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: java.lang.Boolean
     * @Author: tom
     * @Date: 2019/7/23 20:16
     */
    Boolean deleteResource(Integer resourceId);

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Boolean
     * @Author: tom
     * @Date: 2019/7/23 20:16
     */
    Boolean editResource(Resource resource);


}
