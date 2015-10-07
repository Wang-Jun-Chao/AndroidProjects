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
        getParameter("POST", request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameter("GET", request, response);
    }

    private void getParameter(String type, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        OutputStream os = response.getOutputStream();


        if ("post".equalsIgnoreCase(type)) {
            // 使用ISO-8859-1把nam转换成字节数组，再使用UTF-8把字节数转换成字符串
            // 下面的代码可以能用不上（使用GET方式不需要进行转换，使用POST才需要）
//            name = new String(name.getBytes("iso8859-1"), "utf-8");
        }

        System.out.println(type + ": " + name + "::" + pass);
        System.out.println("小志".equals(name) && "123".equals(pass));

        if ("小志".equals(name) && "123".equals(pass)) {
            os.write("登录成功".getBytes("UTF-8"));
        } else {
            os.write("登录失败".getBytes("UTF-8"));
        }
    }
}
