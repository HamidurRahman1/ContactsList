package com.hamidur.webCrawler.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("admin") == null)
        {
            response.sendRedirect("views/Login.jsp");
        }
        else
        {
            response.sendRedirect("views/AdminAccess.jsp");
        }
    }

}
