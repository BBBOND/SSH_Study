package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.service.UserServiceI;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by 伟阳 on 2016/1/21.
 */

@Service(value = "userService")
public class UserServiceImpl implements UserServiceI {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public void test() {
        logger.info("---->userService do test");
    }
}
