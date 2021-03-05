package controller;

import model.entitity.Property;
import model.entitity.User;
import model.dataAccess.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Update", value = "/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = "";
        try {
            type = request.getParameter("type");
        } catch (Exception e) {
            // best practices
        }
        String email = request.getParameter("email");
        User user = UserRepository.find(email);

        if ("add".equals(type)) {

            List<Property> newProperties = user.getProperties();
            newProperties.add(new Property(user.getEmail(), request.getParameter("key"), request.getParameter("value")));
            user.setProperties(newProperties);

            List<Property> properties = user.getProperties();

            RequestDispatcher view = request.getRequestDispatcher("/login-success.jsp");
            request.setAttribute("user", user);
            request.setAttribute("properties", properties);
            view.forward(request, response);
        } else if ("delete".equals(type)) {

            user.getProperties().remove(request.getParameter("n°"));

            user = UserRepository.find(email);
            List<Property> properties = user.getProperties();

            RequestDispatcher view = request.getRequestDispatcher("/login-success.jsp");
            request.setAttribute("user", user);
            request.setAttribute("properties", properties);
            view.forward(request, response);
        }

    }

   /* @Override
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

    }*/


}