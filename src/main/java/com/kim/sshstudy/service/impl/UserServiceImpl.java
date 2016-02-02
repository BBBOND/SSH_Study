package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.TUser;
import com.kim.sshstudy.pageModel.DataGrid;
import com.kim.sshstudy.pageModel.User;
import com.kim.sshstudy.service.UserServiceI;
import com.kim.sshstudy.utils.Md5AndShaEncrypt;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

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

    public Serializable save(TUser tuser) {
        return userDao.save(tuser);
    }

    public User addUser(User user) {
        TUser tuser = new TUser();
        BeanUtils.copyProperties(user, tuser, new String[]{"id", "pwd"});//字符数组是不复制的项
//        tuser.setName(user.getName());
//        tuser.setPwd(user.getPwd());
        tuser.setId(UUID.randomUUID().toString());
        tuser.setPwd(Md5AndShaEncrypt.encrypt(user.getPwd()));
        tuser.setCreatedatatime(new Date());
        tuser.setModifydatatime(new Date());
        userDao.save(tuser);
        BeanUtils.copyProperties(tuser,user);
        return user;
    }

    public User login(User user) {
//        Tuser tuser = userDao.get("from TUser u where u.name='" + user.getName() + "' and u.pwd='" + Md5AndShaEncrypt.encrypt(user.getPwd()) + "'");
//        无法运行(原因antlr版本太低)
//        Tuser tuser = userDao.get("FROM TUser u where u.name = ? and u.pwd = ?", new Object[]{user.getName(), Md5AndShaEncrypt.encrypt(user.getPwd())});
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("pwd", Md5AndShaEncrypt.encrypt(user.getPwd()));
        TUser tuser = userDao.get("FROM TUser u where u.name=:name and u.pwd=:pwd", map);

        if (tuser != null) {
            User u = new User();
            BeanUtils.copyProperties(tuser, u);
            return u;
        } else {
            return null;
        }
    }

    public DataGrid dataGrid(User user) {
        DataGrid dataGrid = new DataGrid();
        String hql = "from TUser t ";
        Map<String, Object> params = new HashMap<String, Object>();
        hql = addWhere(user, hql, params);

        String totalHql = "select count(*) " + hql;
        hql = addOrder(user, hql);
        List<TUser> tUsers = userDao.find(hql, params, user.getPage(), user.getRows());
        List<User> users = changeModel(tUsers);
        dataGrid.setTotal(userDao.count(totalHql, params));
        dataGrid.setRows(users);
        return dataGrid;
    }

    private List<User> changeModel(List<TUser> tUsers) {
        List<User> users = new ArrayList<User>();
        if (tUsers != null && tUsers.size() > 0) {
            for (TUser tUser : tUsers) {
                User u = new User();
                BeanUtils.copyProperties(tUser, u);
                users.add(u);
            }
        }
        return users;
    }

    private String addOrder(User user, String hql) {
        if (user.getSort() != null && !user.getSort().equals("") && user.getOrder() != null && !user.getOrder().equals("")) {
            hql += " order by " + user.getSort() + " " + user.getOrder();
        }
        return hql;
    }

    private String addWhere(User user, String hql, Map<String, Object> params) {
        if (user.getName() != null && !user.getName().trim().equals("")) {
            hql += "where t.name like :name";
            params.put("name", "%%" + user.getName().trim() + "%%");
        }
        return hql;
    }


}
