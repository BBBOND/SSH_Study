package com.kim.sshstudy.action;

import com.alibaba.fastjson.JSON;
import com.kim.sshstudy.model.Userinfo;
import com.kim.sshstudy.service.UserServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
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
public class UserAction {

    private UserServiceI userServiceI;

    public UserServiceI getUserServiceI() {
        return userServiceI;
    }

    @Autowired
    public void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    private static final Logger logger = Logger.getLogger(UserAction.class);

    public void test() {
        logger.info("----->userAction do test");
    }

    public void testSpring() {
        //不用手动获取，直接使用get、set方法上注解@Autowired
        //ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        //UserServiceI userServiceI = (UserServiceI) ac.getBean("userService");
        userServiceI.test();
    }

    public void addUser() {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(UUID.randomUUID().toString());
        userinfo.setName("cy");
        userinfo.setPwd("123456");
        userinfo.setCreatedatatime(new Date());
        userServiceI.save(userinfo);
    }

    public void register() {
        String name = ServletActionContext.getRequest().getParameter("name");
        String pwd = ServletActionContext.getRequest().getParameter("pwd");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userServiceI.add(name, pwd);
            map.put("success", true);
            map.put("msg", "注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "注册失败!");
        }
        try {
//            可设置过滤器解决
            ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
