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
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);

        req.getSession().setAttribute("user", user);

        UserManager userManager = new UserManager();
        userManager.create(user);



        req.getRequestDispatcher("/welcomePage").forward(req, resp);
    }
}
