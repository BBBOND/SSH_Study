package com.kim.sshstudy.action;

import com.alibaba.fastjson.JSON;
import com.kim.sshstudy.pageModel.Menu;
import com.kim.sshstudy.service.MenuServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 伟阳 on 2016/1/28.
 */

@Namespace("/")
@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

    private Menu menu = new Menu();

    public Menu getModel() {
        return menu;
    }

    private MenuServiceI menuService;

    @Autowired
    public void setMenuService(MenuServiceI menuService) {
        this.menuService = menuService;
    }


    /**
     * 异步获取
     */
    public void getTreeNode() {
        writeJson(menuService.getTreeNode(menu.getId()));
    }

    /**
     * 同步获取
     */
    public void getAllTreeNode() {
        writeJson(menuService.getAllTreeNode());
    }
}
