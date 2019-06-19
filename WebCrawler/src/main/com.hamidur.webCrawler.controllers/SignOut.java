package com.hamidur.webCrawler.controllers;

import com.hamidur.webCrawler.services.Attributes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/signOut"})
public class SignOut extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        session.removeAttribute(Attributes.admin.toString());
//        session.invalidate();
        response.sendRedirect("views/Login.jsp");
    }
}
