package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.services.HTMLReader;
import com.hamidur.webCrawler.services.LoginValidatorService;

@WebServlet("/adminAccess")
public class AdminAccess extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try
        {
            LoginValidatorService loginValidatorService = new LoginValidatorService();
            Admin admin = loginValidatorService.verifyLogin(userName, password);
            if(admin != null)
            {
                List<String> files = Arrays.asList
                        ("SignOutAdmin.html", "GetAllQueries.html", "GetAllIndexedUrls.html",
                         "CrawlerForm.html", "SearchQueryForm.html", "BackToAdminAccess.html");

                request.getSession().setAttribute("admin", admin);

                for(String file : files)
                {
                    HTMLReader htmlReader = new HTMLReader(file);

                    if(file.endsWith(".html")) file = file.replace(".html", "");
                    else if(file.endsWith(".jsp")) file = file.replace(".jsp", "");
                    request.getSession().setAttribute(file, htmlReader.getFormAsContent());
                }

                request.getRequestDispatcher("views/AdminAccess.jsp").forward(request, response);
            }
            else
            {
                response.sendRedirect("views/Login.jsp");
            }
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
