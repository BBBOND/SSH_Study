package com.kim.sshstudy.dao;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by 伟阳 on 2016/1/25.
 */
public interface BaseDaoI<T> {

    public Serializable save(T t);

    public T get(String hql);

    public T get(String hql, Object[] params);

    public T get(String hql, Map<String, Object> params);

}
