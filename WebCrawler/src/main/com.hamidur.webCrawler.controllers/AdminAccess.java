package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.services.Attributes;
import com.hamidur.webCrawler.services.LoginValidatorService;
import com.hamidur.webCrawler.services.SessionManager;

@WebServlet(urlPatterns = {"/adminAccess"})
public class AdminAccess extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);
        try
        {
            LoginValidatorService loginValidatorService = new LoginValidatorService();
            Admin admin = loginValidatorService.verifyLogin(userName, password);
            if(admin != null)
            {
                SessionManager.loadAdminPagesToSession(session);
                session.setAttribute(Attributes.admin.toString(), admin);
                response.sendRedirect("views/AdminAccess.jsp");
            }
            else
            {
                response.sendRedirect("views/Login.jsp");
            }
        }
        catch (ClassNotFoundException ex)
        {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (SQLException ex)
        {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (IOException ex)
        {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (Exception ex)
        {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
    }

}
