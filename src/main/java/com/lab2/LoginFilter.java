package com.lab2;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
        urlPatterns ={"/lab2/validation.jsp","/lab2/welcome.jsp"}
)
public class LoginFilter implements Filter {

    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("i am in LoginFilter--doFilter()-- request before chain");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().isNew()){
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(req, resp);
        }else{
            response.sendRedirect(request.getContextPath()+"/lab2/login.jsp");
        }
        chain.doFilter(req, resp);
        System.out.println("i am in LoginFilter--destroy()-- request after chain");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

}