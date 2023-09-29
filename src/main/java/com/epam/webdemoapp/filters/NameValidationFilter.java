package com.epam.webdemoapp.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class NameValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String name = request.getParameter("name");
        if(name.length() > 5){
            chain.doFilter(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Name is not valid.</font>");
            rd.include(request, response);

        }
    }

    @Override
    public void destroy() {

    }
}
