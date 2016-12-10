package com.kim.sshstudy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 伟阳 on 2016/1/30.
 */
@Entity
@Table(name = "t_menu", schema = "", catalog = "sshstudy")
public class TMenu implements Serializable {
    private String id;
    private TMenu tMenu;
    private String text;
    private String iconCls;
    private String url;
    private Set<TMenu> tMenus = new HashSet<TMenu>();

    public TMenu() {
    }

    public TMenu(String id) {
        this.id = id;
    }

    public TMenu(String id, TMenu tMenu, String text, String iconCls, String url, Set<TMenu> tMenus) {
        this.id = id;
        this.tMenu = tMenu;
        this.text = text;
        this.iconCls = iconCls;
        this.url = url;
        this.tMenus = tMenus;
    }

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid")
    public TMenu gettMenu() {
        return tMenu;
    }

    public void settMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }

    @Basic
    @Column(name = "text", nullable = false, length = 100)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "iconCls", nullable = true, length = 50)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tMenu")
    public Set<TMenu> gettMenus() {
        return tMenus;
    }

    public void settMenus(Set<TMenu> tMenus) {
        this.tMenus = tMenus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMenu tMenu = (TMenu) o;

        if (id != null ? !id.equals(tMenu.id) : tMenu.id != null) return false;
        if (text != null ? !text.equals(tMenu.text) : tMenu.text != null) return false;
        if (iconCls != null ? !iconCls.equals(tMenu.iconCls) : tMenu.iconCls != null) return false;
        if (url != null ? !url.equals(tMenu.url) : tMenu.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (iconCls != null ? iconCls.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
