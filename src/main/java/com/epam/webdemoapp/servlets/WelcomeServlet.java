package com.epam.webdemoapp.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("-------Init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //business logic
        String username = req.getParameter("username");
        req.setAttribute("user", username);

        req.getRequestDispatcher("/welcome.jsp").forward(req, resp);

        //representation (то, что видит клиент)
        //resp.getOutputStream().write(("Hello" + username).getBytes());

    }


    @Override
    public void destroy() {
        System.out.println("-------Destroy method");
    }
}
