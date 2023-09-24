package com.epam.webdemoapp.servlets;

import com.epam.webdemoapp.entity.User;
import com.epam.webdemoapp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        req.getSession().setAttribute("user", username + ":" + password);

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setAge(age);


        UserManager userManager = new UserManager();
        userManager.create(user);



        req.getRequestDispatcher("/welcomePage").forward(req, resp);
    }
}
