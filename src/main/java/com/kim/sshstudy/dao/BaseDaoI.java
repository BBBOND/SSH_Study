package com.kim.sshstudy.dao;

import java.io.Serializable;

/**
 * Created by 伟阳 on 2016/1/25.
 */
public interface BaseDaoI<T> {

    public Serializable save(T t);

}
