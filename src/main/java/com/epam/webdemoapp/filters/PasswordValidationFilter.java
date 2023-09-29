package com.epam.webdemoapp.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PasswordValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*?[#?!@$%^&*-]).{8,}";
        String password = request.getParameter("password");
        if(password.matches(pattern)){
            chain.doFilter(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Password is not valid.</font>");
            rd.include(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
