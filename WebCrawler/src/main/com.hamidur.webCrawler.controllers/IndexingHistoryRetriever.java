package com.hamidur.webCrawler.controllers;

import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.util.DBUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        try(Connection connection = DBUtilities.getConnection())
        {
            DaoService daoService = new DaoService(connection);
            List<IndexingHistory> indexingHistories = daoService.getAllIndexingHistories();

            request.setAttribute("indexingHistories", indexingHistories);
            request.getRequestDispatcher("views/DisplayIndexingHistory.jsp").forward(request, response);
        }
        catch (ClassNotFoundException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (SQLException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
    }
}
