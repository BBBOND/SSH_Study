package com.kim.sshstudy.service;

import com.kim.sshstudy.pageModel.Menu;

import java.util.List;

/**
 * Created by 伟阳 on 2016/1/28.
 */
public interface MenuServiceI {

    public void save(Menu menu);

    public List<Menu> getTree(String id);
}
