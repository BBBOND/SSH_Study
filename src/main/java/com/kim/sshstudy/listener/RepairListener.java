package com.kim.sshstudy.listener; /**
 * Created by 伟阳 on 2016/1/29.
 */

import com.kim.sshstudy.service.RepairServiceI;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RepairListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(RepairListener.class);
    private static ApplicationContext applicationContext = null;

    public RepairListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        logger.info("修复数据库");
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        RepairServiceI repairService = (RepairServiceI) applicationContext.getBean("repairService");
        repairService.repair();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

    public void sessionCreated(HttpSessionEvent se) {
    }

    public void sessionDestroyed(HttpSessionEvent se) {
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
    }
}
