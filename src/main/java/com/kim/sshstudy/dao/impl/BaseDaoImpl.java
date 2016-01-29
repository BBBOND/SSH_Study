package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 伟阳 on 2016/1/25.
 */

@Service("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    private SessionFactory sessionFactory;

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Serializable save(T t) {
        return this.sessionFactory.getCurrentSession().save(t);
    }

    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    public void update(T t) {
        getCurrentSession().update(t);
    }

    public void saveOrUpdate(T t) {
        getCurrentSession().saveOrUpdate(t);
    }

    public T get(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

//    public T get(String hql, Object[] params) {
//        Query query = getCurrentSession().createQuery(hql);
//        if (params != null && params.length > 0) {
//            for (int i = 0; i < params.length; i++) {
//                query.setParameter(i, params[i]);
//            }
//        }
//        List<T> list = query.list();
//        if (list != null && list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//    }

    public T get(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
//        使用sql语句
//        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);

//        jdk1.5+
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }

//            jdk1.4-
//            Set<String> keySet = params.keySet();
//            Iterator<String> keys = keySet.iterator();
//            while (keys.hasNext()) {
//                String key = keys.next();
//                query.setParameter(key, params.get(key));
//                key = null;
//            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<T> find(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<T> find(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        return query.list();
    }

    public List<T> find(String hql, int page, int rows) {
        Query query = getCurrentSession().createQuery(hql);
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public Long count(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    public Long count(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        return (Long) query.uniqueResult();
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
