package com.kim.sshstudy;

import com.kim.sshstudy.model.Userinfo;
import com.kim.sshstudy.service.UserServiceI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 伟阳 on 2016/1/23.
 */
public class TestHibernate {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml", "classpath:spring-hibernate.xml");
        UserServiceI userService = (UserServiceI) ac.getBean("userService");
        Userinfo userinfo = new Userinfo();
        userinfo.setId(UUID.randomUUID().toString());
        userinfo.setName("jwy");
        userinfo.setPwd("123456");
        userinfo.setCreatedatatime(new Date());
        userService.save(userinfo);
    }
}
