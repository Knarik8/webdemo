package com.epam.webdemoapp.servlets;

import com.epam.webdemoapp.manager.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserManager userManager = new UserManager();

        if(userManager.getByEmailPassword(email, password)){
            resp.sendRedirect("success.jsp");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

            PrintWriter out= resp.getWriter();
            out.println(String.format("<font color=red>Given user with email: %s and password %s not found</font>", email, password));
            rd.include(req, resp);

        }

    }
}
