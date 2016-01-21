package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.service.UserServiceI;
import org.springframework.stereotype.Service;

/**
 * Created by 伟阳 on 2016/1/21.
 */

@Service(value = "userService")
public class UserServiceImpl implements UserServiceI {
    public void test() {
        System.out.println("test----->>");
    }
}
