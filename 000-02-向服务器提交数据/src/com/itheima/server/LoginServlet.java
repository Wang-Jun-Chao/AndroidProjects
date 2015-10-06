package com.itheima.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Author: 王俊超
 * Date: 2015-10-06
 * Time: 20:40
 * Declaration: All Rights Reserved !!!
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        OutputStream os = response.getOutputStream();

        System.out.println(name + ":" + pass);
        if ("asd".equals(name) && "123".equals(pass)) {
            os.write("登录成功".getBytes());
        } else {
            os.write("登录失败".getBytes());
        }
    }
}
