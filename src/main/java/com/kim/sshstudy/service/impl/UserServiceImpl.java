package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.Userinfo;
import com.kim.sshstudy.pageModel.User;
import com.kim.sshstudy.service.UserServiceI;
import com.kim.sshstudy.utils.Md5AndShaEncrypt;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/21.
 */

@Service(value = "userService")
//使用注解方式配置事务，以下所有方法都应用事务
//@Transactional
public class UserServiceImpl implements UserServiceI {

    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        BeanUtils.copyProperties(user, userinfo, new String[]{"id", "pwd", "createdatatime"});//字符数组是不复制的项
//        userinfo.setName(user.getName());
//        userinfo.setPwd(user.getPwd());
        userinfo.setId(UUID.randomUUID().toString());
        userinfo.setPwd(Md5AndShaEncrypt.encrypt(user.getPwd()));
        userinfo.setCreatedatatime(new Date());
        return userDao.save(userinfo);
    }

    public User login(User user) {


//        Userinfo userinfo = userDao.get("from Userinfo u where u.name='" + user.getName() + "' and u.pwd='" + Md5AndShaEncrypt.encrypt(user.getPwd()) + "'");
//        无法运行
//        Userinfo userinfo = userDao.get("from Userinfo u where u.name = ? and u.pwd = ?", new Object[]{user.getName(), Md5AndShaEncrypt.encrypt(user.getPwd())});

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("pwd", Md5AndShaEncrypt.encrypt(user.getPwd()));
        Userinfo userinfo = userDao.get("from Userinfo u where u.name = :name and u.pwd = :pwd", map);

        if (userinfo != null) {
            User u = new User();
            BeanUtils.copyProperties(userinfo, u);
            return u;
        } else {
            return null;
        }
    }
}
