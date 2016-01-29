package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.model.TMenu;
import com.kim.sshstudy.pageModel.Menu;
import com.kim.sshstudy.service.MenuServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 伟阳 on 2016/1/28.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {

    private MenuDaoI menuDao;

    @Autowired
    public void setMenuDao(MenuDaoI menuDao) {
        this.menuDao = menuDao;
    }

    public void save(Menu menu) {

    }

    public List<Menu> getTree() {
        List<Menu> menus = new ArrayList<Menu>();
        List<TMenu> tMenus = menuDao.find("from TMenu t where t.tMenu is null");
        if (tMenus != null && tMenus.size() > 0) {
            for (TMenu t : tMenus) {
                Menu menu = new Menu();
                BeanUtils.copyProperties(t, menu);
                menus.add(menu);
            }
        }
        return menus;
    }
}
