package com.kim.sshstudy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 伟阳 on 2016/1/28.
 */
@Entity
@Table(name = "menu", schema = "sshstudy")
public class Menu implements Serializable {
    private String id;
    private Menu menu; //父节点
    private String menuName;
    private String menuIcon;
    private String url;
    private Set<Menu> menus = new HashSet<Menu>();

    public Menu() {
    }

    public Menu(String id) {
        this.id = id;
    }

    public Menu(Menu menu, String id, String menuName, String menuIcon, String url, Set<Menu> menus) {
        this.menu = menu;
        this.id = id;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.url = url;
        this.menus = menus;
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
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Basic
    @Column(name = "menu_name", length = 100)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != null ? !id.equals(menu.id) : menu.id != null) return false;
        if (menuName != null ? !menuName.equals(menu.menuName) : menu.menuName != null) return false;
        if (menuIcon != null ? !menuIcon.equals(menu.menuIcon) : menu.menuIcon != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;

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
