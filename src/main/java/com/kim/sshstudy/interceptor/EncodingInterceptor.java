package com.kim.sshstudy.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by 伟阳 on 2016/2/2.
 */
public class EncodingInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        ServletActionContext.getResponse().setCharacterEncoding("utf-8");
        ServletActionContext.getRequest().setCharacterEncoding("utf-8");
        return actionInvocation.invoke();
    }
}
