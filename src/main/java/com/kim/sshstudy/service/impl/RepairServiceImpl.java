package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.model.Menu;
import com.kim.sshstudy.service.RepairServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/28.
 */

@Service("repairService")
public class RepairServiceImpl implements RepairServiceI {

    private MenuDaoI menuDao;

    @Autowired
    public void setMenuDao(MenuDaoI menuDao) {
        this.menuDao = menuDao;
    }

    public void repair() {

        Menu root = new Menu();
        root.setId(UUID.randomUUID().toString());
        root.setMenuName("首页");
        menuDao.saveOrUpdate(root);
    }
}
