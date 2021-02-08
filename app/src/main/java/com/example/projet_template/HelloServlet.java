package com.example.projet_template;

import model.Product;
import repository.ProductRepository;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Product product = new Product("Lampe", 500.0);
        Integer product01Id = ProductRepository.create(product);
        product = ProductRepository.find(product01Id);


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + product + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}