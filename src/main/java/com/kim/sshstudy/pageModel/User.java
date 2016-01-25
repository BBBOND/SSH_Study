package com.kim.sshstudy.pageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 伟阳 on 2016/1/25.
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String pwd;
    private Date createdatatime;
    private Date modifydatatime;

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
