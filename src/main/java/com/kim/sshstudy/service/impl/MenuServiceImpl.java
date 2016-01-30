package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.model.TMenu;
import com.kim.sshstudy.pageModel.Menu;
import com.kim.sshstudy.service.MenuServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 伟阳 on 2016/1/28.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {

    private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

    private MenuDaoI menuDao;

    @Autowired
    public void setMenuDao(MenuDaoI menuDao) {
        this.menuDao = menuDao;
    }

    public void save(Menu menu) {

    }

    public List<Menu> getTreeNode(String id) {
        List<Menu> menus = new ArrayList<Menu>();
        Map<String, Object> map = new HashMap<String, Object>();
        String hql = null;
        if (id == null) {
//            查询所有跟结点
            hql = "from TMenu t where t.tMenu is null";
        } else {
//            查询pid是id的结点
            map.put("id", id);
            hql = "from TMenu t where t.tMenu.id = :id";
        }
        List<TMenu> tMenus = menuDao.find(hql, map);

        if (tMenus != null && tMenus.size() > 0) {
            for (TMenu t : tMenus) {
                Menu menu = new Menu();
                BeanUtils.copyProperties(t, menu);
                Set<TMenu> set = t.gettMenus();
                if (set != null && !set.isEmpty()) {
                    menu.setState("closed");
                } else {
                    menu.setState("open");
                }
                menus.add(menu);
            }
        }
        return menus;
    }

    public List<Menu> getAllTreeNode() {
        List<Menu> menus = new ArrayList<Menu>();
        String hql = "from TMenu t";
        List<TMenu> tMenus = menuDao.find(hql);
        if (tMenus != null && tMenus.size() > 0) {
            for (TMenu t : tMenus) {
                Menu menu = new Menu();
                BeanUtils.copyProperties(t, menu);
                TMenu tm = t.gettMenu();
                if (tm != null) {
                    menu.setPid(tm.getId());
                }
                menus.add(menu);
            }
        }
        return menus;
    }
}
