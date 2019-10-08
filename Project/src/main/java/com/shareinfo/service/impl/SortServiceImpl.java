package com.shareinfo.service.impl;

import com.shareinfo.dao.SortDao;
import com.shareinfo.service.SortService;
import com.shareinfo.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2019/5/16 23:33
 * @author zxx
 */
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    SortDao sortDao;

    /**
     * get sortList
     *
     * @Description get sortList
     * @param void
     * @return if dao is success return sortList else throw error
     * */
    @Override
    public List<Sort> getAllSort() {
        return sortDao.getAllSort();
    }
}
