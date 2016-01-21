package com.kim.sshstudy.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 伟阳 on 2016/1/21.
 */
@Entity
@Table(name = "userinfo", schema = "", catalog = "sshstudy")
public class UserinfoEntity {
    private String id;
    private String name;
    private String pwd;
    private Date createdatatime;
    private Date modifydatatime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "createdatatime")
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

        UserinfoEntity that = (UserinfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (createdatatime != null ? !createdatatime.equals(that.createdatatime) : that.createdatatime != null)
            return false;
        if (modifydatatime != null ? !modifydatatime.equals(that.modifydatatime) : that.modifydatatime != null)
            return false;

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
