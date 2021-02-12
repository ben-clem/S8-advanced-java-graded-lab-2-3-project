package controller;

import model.User;
import repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "Update", value = "/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean delete = false;
        try {
            delete = request.getParameter("delete").equals("True");
        } catch (Exception e) {
            // best practices
        }
        String email = request.getParameter("email");

        User user = UserRepository.find(email);

        if (delete)
        {
            UserRepository.delete(user);

            RequestDispatcher view = request.getRequestDispatcher("/signout-success.jsp");
            view.forward(request, response);
        }
        else {
            user.setDateLastAccess(new Date());
            UserRepository.update(user);

            RequestDispatcher view = request.getRequestDispatcher("/login-success.jsp");
            request.setAttribute("user", user);
            view.forward(request, response);
        }

    }


}