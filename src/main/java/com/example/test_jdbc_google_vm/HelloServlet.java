package com.example.test_jdbc_google_vm;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/test")
public class HelloServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "jdbc:mysql://34.118.53.210:3306/trackerDB";
        String user = "dev";
        String password = "!1Aarootroot";
        PrintWriter out = response.getWriter();
        out.println("trying with com.mysql.cj.jdbc.Driver google");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);


            out.println("Connected to the database "+url+"!");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {

            out.println("Connection failed! Error: " + e);
        }
    }

    public void destroy() {
    }
}