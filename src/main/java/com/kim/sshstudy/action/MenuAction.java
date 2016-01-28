package com.kim.sshstudy.action;

import com.kim.sshstudy.pageModel.Menu;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

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
}
