package com.shareinfo.web;

import com.shareinfo.service.SortService;
import com.shareinfo.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @date 2019/5/16 23:34
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/sort")
public class SortController {

    @Autowired
    SortService sortService;


    /**
     * @Effect : 获取所有的分类
     */
    @RequestMapping(value = "/getAllSort" , method = RequestMethod.GET)
    private Map<String , Object> getAllSort() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Sort> list = new ArrayList<Sort>();
        // 获取用户文章信息
        list = sortService.getAllSort();
        if (list.isEmpty()) {
            modelMap.put("status" , 0);
            return modelMap;
        } else {
            modelMap.put("status" , 1);
            modelMap.put("data" , list);
            return modelMap;
        }
    }

}
