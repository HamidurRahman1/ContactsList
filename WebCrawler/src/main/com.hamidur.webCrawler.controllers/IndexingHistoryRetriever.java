package com.hamidur.webCrawler.controllers;

import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.services.AdminAccessiblePages;
import com.hamidur.webCrawler.services.Attributes;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.util.DBUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/indexedUrls"})
public class IndexingHistoryRetriever extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(AdminAccessiblePages.validateAdminAccessiblePages(request, response))
        {
            HttpSession session = request.getSession(false);
            try(Connection connection = DBUtilities.getConnection())
            {
                DaoService daoService = new DaoService(connection);
                List<IndexingHistory> indexingHistories = daoService.getAllIndexingHistories();

                session.setAttribute(Attributes.indexingHistories.toString(), indexingHistories);
                response.sendRedirect("views/DisplayIndexingHistory.jsp");
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
            catch (Exception ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
        }
        else
        {
            response.sendRedirect("../errors/DisplayErrors.jsp");
        }
    }
}
