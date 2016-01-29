package com.kim.sshstudy.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 伟阳 on 2016/1/29.
 */
@Entity
@Table(name = "t_user", schema = "", catalog = "sshstudy")
public class TUser {
    private String id;
    private String name;
    private String pwd;
    private Date createdatatime;
    private Date modifydatatime;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", unique = true, nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 64)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "createdatatime", nullable = false)
    public Date getCreatedatatime() {
        return createdatatime;
    }

    public void setCreatedatatime(Date createdatatime) {
        this.createdatatime = createdatatime;
    }

    @Basic
    @Column(name = "modifydatatime")
    public Date getModifydatatime() {
        return modifydatatime;
    }

    public void setModifydatatime(Date modifydatatime) {
        this.modifydatatime = modifydatatime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUser tUser = (TUser) o;

        if (id != null ? !id.equals(tUser.id) : tUser.id != null) return false;
        if (name != null ? !name.equals(tUser.name) : tUser.name != null) return false;
        if (pwd != null ? !pwd.equals(tUser.pwd) : tUser.pwd != null) return false;
        if (createdatatime != null ? !createdatatime.equals(tUser.createdatatime) : tUser.createdatatime != null) return false;
        if (modifydatatime != null ? !modifydatatime.equals(tUser.modifydatatime) : tUser.modifydatatime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (createdatatime != null ? createdatatime.hashCode() : 0);
        result = 31 * result + (modifydatatime != null ? modifydatatime.hashCode() : 0);
        return result;
    }
}