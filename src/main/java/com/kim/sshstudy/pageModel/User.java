package com.kim.sshstudy.pageModel;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 伟阳 on 2016/1/25.
 */
public class User implements Serializable {
    private int page;
    private int rows;
    private String sort;
    private String order;

    private String id;
    private String name;
    private String pwd;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdatatime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifydatatime;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreatedatatime() {
        return createdatatime;
    }

    public void setCreatedatatime(Date createdatatime) {
        this.createdatatime = createdatatime;
    }

    public Date getModifydatatime() {
        return modifydatatime;
    }

    public void setModifydatatime(Date modifydatatime) {
        this.modifydatatime = modifydatatime;
    }
}
