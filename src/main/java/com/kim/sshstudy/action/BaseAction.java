package com.kim.sshstudy.action;

import com.alibaba.fastjson.JSON;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * Created by 伟阳 on 2016/1/25.
 */

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {

    public void writeJson(Object object) {
        try {
            String json = JSON.toJSONString(object);
            ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().write(json);
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
