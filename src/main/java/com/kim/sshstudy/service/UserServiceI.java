package com.kim.sshstudy.service;

import com.kim.sshstudy.model.TUser;
import com.kim.sshstudy.pageModel.DataGrid;
import com.kim.sshstudy.pageModel.User;

import java.io.Serializable;

/**
 * Created by 伟阳 on 2016/1/21.
 */
public interface UserServiceI {
    public void test();

    public Serializable save(TUser tuser);

    public User addUser(User user);

    public User login(User user);

    public DataGrid dataGrid(User user);

    public void remove(String ids);

    public void edit(User user);
}
