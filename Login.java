package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            response.sendRedirect("home");

        } else {
            response.getWriter().println("Invalid username or password");
        }
    }
}