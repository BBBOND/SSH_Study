package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.Userinfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 伟阳 on 2016/1/23.
 */

@Repository("userDao")
public class UserDaoImpl implements UserDaoI {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable save(Userinfo userinfo) {
        return this.sessionFactory.getCurrentSession().save(userinfo);
    }
}
