package com.kim.sshstudy;

import com.kim.sshstudy.model.TUser;
import com.kim.sshstudy.service.UserServiceI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
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
        TUser tuser = new TUser();
        tuser.setId(UUID.randomUUID().toString());
        tuser.setName("jwy");
        tuser.setPwd("123456");
        tuser.setCreatedatetime(new Timestamp(System.currentTimeMillis()));
        userService.save(tuser);
    }
}
