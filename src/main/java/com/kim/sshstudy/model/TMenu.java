package com.kim.sshstudy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 伟阳 on 2016/1/29.
 */
@Entity
@Table(name = "t_menu", schema = "", catalog = "sshstudy")
public class TMenu {
    private String id;
    private TMenu tMenu; //父节点
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
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    public TMenu gettMenu() {
        return tMenu;
    }

    public void settMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }

    @Basic
    @Column(name = "text", unique = true, length = 100)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "iconCls", length = 50)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tMenu")
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

        TMenu tMenu1 = (TMenu) o;

        if (!id.equals(tMenu1.id)) return false;
        if (!tMenu.equals(tMenu1.tMenu)) return false;
        if (!text.equals(tMenu1.text)) return false;
        if (!iconCls.equals(tMenu1.iconCls)) return false;
        if (!url.equals(tMenu1.url)) return false;
        return tMenus.equals(tMenu1.tMenus);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tMenu.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + iconCls.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + tMenus.hashCode();
        return result;
    }
}
