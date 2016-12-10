package com.kim.sshstudy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 伟阳 on 2016/1/30.
 */
@Entity
@Table(name = "t_user", schema = "", catalog = "sshstudy")
public class TUser implements Serializable {
    private String id;
    private String name;
    private String pwd;
    private Date createdatetime;
    private Date modifydatetime;

    public TUser() {
    }

    public TUser(String id) {
        this.id = id;
    }

    public TUser(String id, String name, String pwd, Date createdatetime, Date modifydatetime) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.createdatetime = createdatetime;
        this.modifydatetime = modifydatetime;
    }

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdatetime", nullable = false)
    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifydatetime", nullable = false)
    public Date getModifydatetime() {
        return modifydatetime;
    }

    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUser tUser = (TUser) o;

        if (id != null ? !id.equals(tUser.id) : tUser.id != null) return false;
        if (name != null ? !name.equals(tUser.name) : tUser.name != null) return false;
        if (pwd != null ? !pwd.equals(tUser.pwd) : tUser.pwd != null) return false;
        if (createdatetime != null ? !createdatetime.equals(tUser.createdatetime) : tUser.createdatetime != null) return false;
        if (modifydatetime != null ? !modifydatetime.equals(tUser.modifydatetime) : tUser.modifydatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (createdatetime != null ? createdatetime.hashCode() : 0);
        result = 31 * result + (modifydatetime != null ? modifydatetime.hashCode() : 0);
        return result;
    }
}
