package com.epam.webdemoapp.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PasswordValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pattern = "(?=.*[0-9])(?=.*[a-z]).{8,}";
        String password = request.getParameter("password");
        if(password.matches(pattern)){
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/webdemo1/error");
        }
    }

    @Override
    public void destroy() {

    }
}
