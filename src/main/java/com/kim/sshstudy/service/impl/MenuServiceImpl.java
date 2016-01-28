package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.pageModel.Menu;
import com.kim.sshstudy.service.MenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
