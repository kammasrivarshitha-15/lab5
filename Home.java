package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        PrintWriter out = response.getWriter();

        if (session != null &&
                session.getAttribute("username") != null) {

            String username =
                    (String) session.getAttribute("username");

            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>You are successfully logged in.</p>");

            out.println("<a href='logout'>Logout</a>");

            out.println("</body>");
            out.println("</html>");

        } else {

            out.println("<h2>Please login first!</h2>");
        }
    }
}