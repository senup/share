package com.shareinfo.entity;

import java.io.Serializable;

/**
 * @author kxt
 * @date 2019/7/22 19:47
 */
public class Resource implements Serializable {

    private Integer resourceId;
    private String resourceTitle;
    private String resourceLink;
    private String resourceCode;
    private Double resourceSize;
    private String resourceIntro;
    private Integer uploadUser;
    private String dateTime;
    private String validDate;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Double getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Double resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceIntro() {
        return resourceIntro;
    }

    public void setResourceIntro(String resourceIntro) {
        this.resourceIntro = resourceIntro;
    }

    public Integer getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(Integer uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
}
