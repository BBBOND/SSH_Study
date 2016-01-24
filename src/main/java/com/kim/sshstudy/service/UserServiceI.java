package com.kim.sshstudy.service;

import com.kim.sshstudy.model.Userinfo;

import java.io.Serializable;

/**
 * Created by 伟阳 on 2016/1/21.
 */
public interface UserServiceI {
    public void test();

    public Serializable save(Userinfo userinfo);

    public Serializable add(String name, String pwd);
}
