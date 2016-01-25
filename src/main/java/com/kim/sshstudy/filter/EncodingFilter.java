package com.kim.sshstudy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 伟阳 on 2016/1/25.
 */
public class EncodingFilter implements Filter {

    private String encoding = "";
    private String contentType = "";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (encoding != null && !encoding.equals("")) {
            req.setCharacterEncoding(encoding);
            resp.setContentType(contentType);
            resp.setCharacterEncoding(encoding);
        } else {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        contentType = config.getInitParameter("contentType");
    }

}
