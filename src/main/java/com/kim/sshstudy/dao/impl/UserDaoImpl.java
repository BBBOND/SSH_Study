package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.TUser;
import org.springframework.stereotype.Repository;

/**
 * Created by 伟阳 on 2016/1/23.
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<TUser> implements UserDaoI {
}
