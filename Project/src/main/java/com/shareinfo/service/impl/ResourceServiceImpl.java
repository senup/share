package com.shareinfo.service.impl;

import com.shareinfo.dao.ResourceDao;
import com.shareinfo.entity.Resource;
import com.shareinfo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ResourceServiceImpl
 * @Description TODO
 * @Author tom
 * @Date 2019/7/22 10:10
 * @Version 1.0
 **/
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Integer
     * @Author: tom
     * @Date: 2019/7/22 10:13
     */
    public Boolean insertResource(Resource resource) {
        try{
            Integer i = resourceDao.insertResource(resource);
            if(i==1){
                return true;
            }else{
                throw new RuntimeException("添加资源出错！！！");
            }

        }catch (Exception e){
            throw new RuntimeException("数据库出错！！！");
        }

    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: []
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/23 20:18
     */
    @Override
    public List<Resource> findAllResource() {
        return resourceDao.findAllResource();
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: com.shareinfo.entity.Resource
     * @Author: tom
     * @Date: 2019/7/23 20:18
     */
    @Override
    public Resource findResourceById(Integer resourceId) {
        try{
            Resource resource = resourceDao.findResourceById(resourceId);
            if(resource==null){
                throw new RuntimeException("获取资源为空!!!");
            }else{
                return resource;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库异常！！！"+e.toString());

        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceTitle]
     * @Return: java.util.List<com.shareinfo.entity.Resource>
     * @Author: tom
     * @Date: 2019/7/23 20:18
     */
    @Override
    public List<Resource> findResourceByTitle(String resourceTitle) {
        try{
            List<Resource> resource=resourceDao.findResourceByTitle(resourceTitle);
            if(resource.isEmpty()){
                throw new RuntimeException("获取资源为空!!!");
            }else{
                return resource;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库异常！！！"+e.toString());
        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: java.lang.Boolean
     * @Author: tom
     * @Date: 2019/7/23 20:18
     */
    @Override
    public Boolean deleteResource(Integer resourceId) {
        try{

            Integer i = resourceDao.deleteResource(resourceId);
            if(i==1){
                return true;
            }else{
                throw  new RuntimeException("impl层删除出错！！");
            }

        }catch (Exception e){
            throw new RuntimeException("数据库异常！！！");
        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.lang.Boolean
     * @Author: tom
     * @Date: 2019/7/23 20:18
     */
    @Override
    public Boolean editResource(Resource resource) {
        try{
            Integer i = resourceDao.editResource(resource);
            if(i==1){
                return true;
            }else{
                throw new RuntimeException("impl层更新出错！！");
            }
        }catch (Exception e){
            throw new RuntimeException("数据库异常！！！");
        }
    }


}
