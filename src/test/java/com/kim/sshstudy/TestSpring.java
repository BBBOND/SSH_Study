package com.kim.sshstudy;

import com.kim.sshstudy.service.UserServiceI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 伟阳 on 2016/1/21.
 */
public class TestSpring {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
        UserServiceI userService = (UserServiceI) ac.getBean("userService");
        userService.test();
    }
}
