package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.BaseDaoI;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by 伟阳 on 2016/1/25.
 */

@Service("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable save(T t) {
        return sessionFactory.getCurrentSession().save(t);
    }
}
