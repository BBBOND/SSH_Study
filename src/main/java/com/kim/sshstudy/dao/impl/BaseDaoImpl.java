package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return this.sessionFactory.getCurrentSession().save(t);
    }

    public T get(String hql) {
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public T get(String hql, Object[] params) {
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public T get(String hql, Map<String, Object> params) {
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            Set<String> keySet = params.keySet();
            Iterator<String> keys = keySet.iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                query.setParameter(key, params.get(key));
                key = null;
            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
