package com.kim.sshstudy.action;

import com.kim.sshstudy.model.TUser;
import com.kim.sshstudy.pageModel.Json;
import com.kim.sshstudy.pageModel.User;
import com.kim.sshstudy.service.UserServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/23.
 */

//@ParentPackage("basePackage")
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
        TUser tuser = new TUser();
        tuser.setId(UUID.randomUUID().toString());
        tuser.setName("cy");
        tuser.setPwd("123456");
        tuser.setCreatedatatime(new Date());
        userService.save(tuser);
    }

    public void register() {
//        获取方法一
//        String name = ServletActionContext.getRequest().getParameter("name");
//        String pwd = ServletActionContext.getRequest().getParameter("pwd");
        Json json = new Json();
        try {
            userService.addUser(user);
            json.setSuccess(true);
            json.setMsg("注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg("注册失败!");
        }
        super.writeJson(json);
    }

    public void login() {
        Json json = new Json();
        try {
            User u = userService.login(user);
            if (u != null) {
                json.setSuccess(true);
                json.setMsg("登陆成功!");
            } else {
                json.setSuccess(false);
                json.setMsg("登陆失败,登录名或密码错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg("登陆失败,服务器内部错误!");
        } finally {
            super.writeJson(json);
        }
    }
}
