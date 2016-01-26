package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.Userinfo;
import com.kim.sshstudy.pageModel.User;
import com.kim.sshstudy.service.UserServiceI;
import com.kim.sshstudy.utils.Md5AndShaEncrypt;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/21.
 */

@Service(value = "userService")
//使用注解方式配置事务，以下所有方法都应用事务
//@Transactional
public class UserServiceImpl implements UserServiceI {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public void test() {
        logger.info("---->userService do test");
    }

    private UserDaoI userDao;

    public UserDaoI getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDaoI userDao) {
        this.userDao = userDao;
    }

    public Serializable save(Userinfo userinfo) {
        return userDao.save(userinfo);
    }

    public Serializable addUser(User user) {
        Userinfo userinfo = new Userinfo();
        BeanUtils.copyProperties(user,userinfo,new String[]{"id","pwd","createdatatime"});//字符数组是不复制的项
//        userinfo.setName(user.getName());
//        userinfo.setPwd(user.getPwd());
        userinfo.setId(UUID.randomUUID().toString());
        userinfo.setPwd(Md5AndShaEncrypt.encrypt(user.getPwd()));
        userinfo.setCreatedatatime(new Date());
        return userDao.save(userinfo);
    }
}
