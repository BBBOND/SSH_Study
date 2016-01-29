package com.kim.sshstudy.service.impl;

import com.kim.sshstudy.dao.MenuDaoI;
import com.kim.sshstudy.dao.UserDaoI;
import com.kim.sshstudy.model.TMenu;
import com.kim.sshstudy.model.TUser;
import com.kim.sshstudy.service.RepairServiceI;
import com.kim.sshstudy.utils.Md5AndShaEncrypt;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/28.
 */

@Namespace("/")
@Service("repairService")
//@Transactional
public class RepairServiceImpl implements RepairServiceI {

    private MenuDaoI menuDao;
    private UserDaoI userDao;

    @Autowired
    public void setMenuDao(MenuDaoI menuDao) {
        this.menuDao = menuDao;
    }

    @Autowired
    public void setUserDao(UserDaoI userDao) {
        this.userDao = userDao;
    }

    public void repair() {
        repairMenu();
        repairUser();
    }

    private void repairMenu() {
        TMenu root = new TMenu();
        root.setId("0");
        root.setText("首页");
        root.setUrl("");
        menuDao.saveOrUpdate(root);

        TMenu xtgl = new TMenu();
        xtgl.setId("xtgl");
        xtgl.settMenu(root);
        xtgl.setText("系统管理");
        xtgl.setUrl("");
        menuDao.saveOrUpdate(xtgl);

        TMenu sjkgl = new TMenu();
        sjkgl.setId("sjkgl");
        sjkgl.settMenu(root);
        sjkgl.setText("数据库管理");
        sjkgl.setUrl("");
        menuDao.saveOrUpdate(sjkgl);

        TMenu rzgl = new TMenu();
        rzgl.setId("rzgl");
        rzgl.settMenu(root);
        rzgl.setText("日志管理");
        rzgl.setUrl("");
        menuDao.saveOrUpdate(rzgl);

        TMenu druidjk = new TMenu();
        druidjk.setId("druidjk");
        druidjk.settMenu(sjkgl);
        druidjk.setText("druid监控");
        druidjk.setUrl("");
        menuDao.saveOrUpdate(druidjk);

        TMenu yhgl = new TMenu();
        yhgl.setId("yhgl");
        yhgl.settMenu(xtgl);
        yhgl.setText("用户管理");
        yhgl.setUrl("");
        menuDao.saveOrUpdate(yhgl);

        TMenu jsgl = new TMenu();
        jsgl.setId("jsgl");
        jsgl.settMenu(xtgl);
        jsgl.setText("角色管理");
        jsgl.setUrl("");
        menuDao.saveOrUpdate(jsgl);

        TMenu qxgl = new TMenu();
        qxgl.setId("qxgl");
        qxgl.settMenu(xtgl);
        qxgl.setText("权限管理");
        qxgl.setUrl("");
        menuDao.saveOrUpdate(qxgl);

        TMenu cdgl = new TMenu();
        cdgl.setId("cdgl");
        cdgl.settMenu(xtgl);
        cdgl.setText("菜单管理");
        cdgl.setUrl("");
        menuDao.saveOrUpdate(yhgl);

        TMenu buggl = new TMenu();
        buggl.setId("buggl");
        buggl.settMenu(xtgl);
        buggl.setText("BUG管理");
        buggl.setUrl("");
        menuDao.saveOrUpdate(buggl);

        TMenu yhdlrz = new TMenu();
        yhdlrz.setId("yhdlrz");
        yhdlrz.settMenu(rzgl);
        yhdlrz.setText("用户登陆日志");
        yhdlrz.setUrl("");
        menuDao.saveOrUpdate(yhdlrz);

        TMenu yhzxrz = new TMenu();
        yhzxrz.setId("yhzxrz");
        yhzxrz.settMenu(rzgl);
        yhzxrz.setText("用户注销日志");
        yhzxrz.setUrl("");
        menuDao.saveOrUpdate(yhzxrz);

        TMenu yhglrz = new TMenu();
        yhglrz.setId("yhglrz");
        yhglrz.settMenu(rzgl);
        yhglrz.setText("用户管理日志");
        yhglrz.setUrl("");
        menuDao.saveOrUpdate(yhglrz);

        TMenu jsglrz = new TMenu();
        jsglrz.setId("jsglrz");
        jsglrz.settMenu(rzgl);
        jsglrz.setText("角色管理日志");
        jsglrz.setUrl("");
        menuDao.saveOrUpdate(jsglrz);

        TMenu qxglrz = new TMenu();
        qxglrz.setId("qxglrz");
        qxglrz.settMenu(rzgl);
        qxglrz.setText("权限管理日志");
        qxglrz.setUrl("");
        menuDao.saveOrUpdate(qxglrz);

        TMenu cdglrz = new TMenu();
        cdglrz.setId("cdglrz");
        cdglrz.settMenu(rzgl);
        cdglrz.setText("菜单管理日志");
        cdglrz.setUrl("");
        menuDao.saveOrUpdate(cdglrz);

        menuDao.flush();
    }

    private void repairUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "admin");
        TUser tuser = userDao.get("from TUser t where t.name = :name and t.id != '0'", map);
        if (tuser != null) {
            tuser.setName(UUID.randomUUID().toString());
            userDao.flush();
        }

        TUser admin = new TUser();
        admin.setId("0");
        admin.setName("admin");
        admin.setPwd(Md5AndShaEncrypt.encrypt("admin"));
        admin.setCreatedatatime(new Date());
        admin.setModifydatatime(new Date());
        userDao.saveOrUpdate(admin);
        userDao.flush();
    }
}
