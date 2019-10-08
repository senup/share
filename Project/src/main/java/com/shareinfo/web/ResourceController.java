package com.shareinfo.web;

import com.shareinfo.entity.Resource;
import com.shareinfo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName resourceController
 * @Description TODO
 * @Author tom
 * @Date 2019/7/22 8:59
 * @Version 1.0
 **/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/resource")
public class ResourceController {
    /*
    根据Id查找资源
    根据Id删除资源
    根据Id修改资源
    新增资源
     */
    @Autowired
    ResourceService resourceService;

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: []
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/findAll")
    public Map<String,Object> findAll(){
        List<Resource> list = resourceService.findAllResource();
        Map<String , Object> modelMap = new HashMap<String, Object>();
            modelMap.put("status" , 1);
            modelMap.put("data" , list);
            return modelMap;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/findResourceById")
    public Map<String,Object> findResourceById(Integer resourceId){
        Map<String,Object> modelMap = new HashMap();
        Resource resource = resourceService.findResourceById(resourceId);
        modelMap.put("status",1);
        modelMap.put("data",resource);
        return modelMap;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceTitle]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/findResourceByTitle")
    public Map<String,Object> findResourceByTitle(String resourceTitle){
        Map<String,Object> modelMap = new HashMap();
        List<Resource> resource = resourceService.findResourceByTitle(resourceTitle);
        modelMap.put("status",1);
        modelMap.put("data",resource);
        return modelMap;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/insertResource")
    public Map<String , Object> insertResource(Resource resource){
        Map<String,Object> modelMap = new HashMap();
        if(resourceService.insertResource(resource)){
            modelMap.put("status",1);
            return modelMap;
        }else{
            throw  new RuntimeException("新增资源：Controller层出错！！！");
        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resourceId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/deleteResource")
    public Map<String,Object> deleteResource(Integer resourceId){
        Map<String,Object> modelMap = new HashMap();
        if(resourceService.deleteResource(resourceId)){
            modelMap.put("status",1);
            return modelMap;
        }else{
            throw  new RuntimeException("删除资源：Controller层出错！！！");
        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [resource]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/7/23 20:19
     */
    @RequestMapping("/editResource")
    public Map<String,Object> editResource(Resource resource){
        Map<String,Object> modelMap = new HashMap();
        if(resourceService.editResource(resource)){
            modelMap.put("status",1);
            return modelMap;
        }else{
            throw  new RuntimeException("更新资源：Controller层出错！！！");
        }
    }

}
