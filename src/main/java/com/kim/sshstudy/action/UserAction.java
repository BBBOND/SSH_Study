package com.kim.sshstudy.action;

import com.kim.sshstudy.service.UserServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

    public void test(){
        logger.info("----->userAction do test");
    }

    public void testSpring(){
        //不用手动获取，直接使用get、set方法上注解@Autowired
        //ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        //UserServiceI userServiceI = (UserServiceI) ac.getBean("userService");
        userServiceI.test();
    }


}
