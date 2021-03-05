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

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");

        if (passwordConfirm.equals(password)) // sign up
        {
            User user = new User(new Date(), new Date(), null, email, password);
            try {
                UserRepository.create(user);
            }
            catch (Exception e) {
                // todo utilisateur deja existant
                // redirect vers index /w error
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            }

            RequestDispatcher view = request.getRequestDispatcher("/login-success.jsp");
            request.setAttribute("user", (Object)user);
            view.forward(request, response);
        } else { // login
            try {
                User user = UserRepository.find(email);
                List<Property> properties = user.getProperties();
                if (user.getPassword().equals(password)) {
                    user.setDateLastSignIn(new Date());
                    UserRepository.update(user);
                    RequestDispatcher view = request.getRequestDispatcher("/login-success.jsp");
                    request.setAttribute("user", user);
                    request.setAttribute("properties", properties);
                    view.forward(request, response);
                } else {
                    // todo redirect index w/error
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                }
            } catch (Exception e) {
                // TODO redirect index (w/ error)
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            }
        }

    }


}