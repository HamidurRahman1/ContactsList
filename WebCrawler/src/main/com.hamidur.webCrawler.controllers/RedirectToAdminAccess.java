package com.hamidur.webCrawler.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/backToAdminAccess"})
public class RedirectToAdminAccess extends HttpServlet
{
    @Override
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
