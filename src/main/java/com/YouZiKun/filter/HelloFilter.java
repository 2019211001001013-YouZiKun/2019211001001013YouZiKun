package com.YouZiKun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
    //urlPatterns = "/hello"
    //urlPatterns = {"/*"}
    //urlPatterns = {"home","login","register.jsp"}
    urlPatterns = "/hello"
)
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
