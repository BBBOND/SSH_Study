package com.kim.sshstudy.action;

import com.kim.sshstudy.model.Userinfo;
import com.kim.sshstudy.pageModel.User;
import com.kim.sshstudy.service.UserServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/23.
 */

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

    User user = new User();

    public User getModel() {
        return user;
    }

    private UserServiceI userService;

    public UserServiceI getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

//    获取方法二
    /*private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }*/

    private static final Logger logger = Logger.getLogger(UserAction.class);

    public void test() {
        logger.info("----->userAction do test");
    }

    public void testSpring() {
        //不用手动获取，直接使用get、set方法上注解@Autowired
        //ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        //UserServiceI userServiceI = (UserServiceI) ac.getBean("userService");
        userService.test();
    }

    public void addUser() {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(UUID.randomUUID().toString());
        userinfo.setName("cy");
        userinfo.setPwd("123456");
        userinfo.setCreatedatatime(new Date());
        userService.save(userinfo);
    }

    public void register() {
//        获取方法一
//        String name = ServletActionContext.getRequest().getParameter("name");
//        String pwd = ServletActionContext.getRequest().getParameter("pwd");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userService.add(user.getName(), user.getPwd());
            map.put("success", true);
            map.put("msg", "注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "注册失败!");
        }
        super.writeJson(map);
    }

}
