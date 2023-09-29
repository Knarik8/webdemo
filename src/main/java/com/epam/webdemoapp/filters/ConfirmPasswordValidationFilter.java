package com.epam.webdemoapp.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfirmPasswordValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(confirmPassword.equals(password)){
            chain.doFilter(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Password and its confirmation do not match</font>");
            rd.include(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
