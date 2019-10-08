package com.shareinfo.service;

import com.shareinfo.entity.Sort;

import java.util.List;

/**
 * @author zxx
 * */
public interface SortService {

    /**
     * get sortList
     *
     * @Description get sortList
     * @param void
     * @return if dao is success return sortList else throw error
     * */
    List<Sort> getAllSort();

}
