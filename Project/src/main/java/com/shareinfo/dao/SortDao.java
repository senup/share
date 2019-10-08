package com.shareinfo.dao;

import com.shareinfo.entity.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zxx
 * */
public interface SortDao {

    /**
     * get sortList
     *
     * @Description get sortList
     * @param void
     * @return all sort's list
     * */
    List<Sort> getAllSort();

    /**
     * get sortName
     *
     * @Description get sortName
     * @param sortId
     * @return sortName
     * */
    String getSortNameBySortId(@Param("sortId") Integer sortId);

}
