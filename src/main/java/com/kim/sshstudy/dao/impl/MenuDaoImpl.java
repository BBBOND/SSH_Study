package com.kim.sshstudy.dao.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.model.Menu;
import org.springframework.stereotype.Service;

/**
 * Created by 伟阳 on 2016/1/28.
 */
@Service("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDaoI {
}
