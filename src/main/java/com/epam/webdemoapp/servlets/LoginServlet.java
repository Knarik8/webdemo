package com.epam.webdemoapp.servlets;

import com.epam.webdemoapp.entity.User;
import com.epam.webdemoapp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserManager userManager = new UserManager();
        User user = userManager.getByUsernamePassword(name, password);
        req.getSession().setAttribute("user", user.getName() + ":" + user.getPassword());


        req.getRequestDispatcher("/welcomePage").forward(req, resp);


    }
}
