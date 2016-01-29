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
    private String menuName;
    private String menuIcon;
    private String url;
    private Set<TMenu> tMenus = new HashSet<TMenu>();

    public TMenu() {
    }

    public TMenu(String id) {
        this.id = id;
    }

    public TMenu(String id, TMenu tMenu, String menuName, String menuIcon, String url) {
        this.id = id;
        this.tMenu = tMenu;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.url = url;
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
    @Column(name = "menu_name", unique = true, length = 100)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "menu_icon", length = 50)
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Basic
    @Column(name = "url", length = 200)
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

        TMenu tMenu = (TMenu) o;

        if (id != null ? !id.equals(tMenu.id) : tMenu.id != null) return false;
        if (menuName != null ? !menuName.equals(tMenu.menuName) : tMenu.menuName != null) return false;
        if (menuIcon != null ? !menuIcon.equals(tMenu.menuIcon) : tMenu.menuIcon != null) return false;
        if (url != null ? !url.equals(tMenu.url) : tMenu.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (menuIcon != null ? menuIcon.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
