package com.shareinfo.entity;

import java.io.Serializable;

/**
 * @author zxx
 * @date 2019/5/16 23:30
 * @POJO 分类的实体类
 */
public class Sort implements Serializable {

    Integer sortId;
    String sortName;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
