package controller;

import model.User;
import repository.UserRepository;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginSuccess", value = "/success")
public class LoginSuccess extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = new User(new Date(), new Date(), new Date(), "email", "pass");
        String user01Id = UserRepository.create(user);
        user = UserRepository.find(user01Id);


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + user + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}