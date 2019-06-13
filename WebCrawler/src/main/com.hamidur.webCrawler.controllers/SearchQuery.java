package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.models.SearchHistory;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.services.HTMLReader;
import com.hamidur.webCrawler.services.TimeCalculator;
import com.hamidur.webCrawler.util.DBUtilities;

@WebServlet(urlPatterns = {"/queryTheSearch"})
public class SearchQuery extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String query = request.getParameter("query");
        response.setContentType("text/html");
        if(query.isEmpty())
        {
            response.getWriter().append("You submitted an empty search query.");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        else
        {
            try(Connection connection = DBUtilities.getConnection())
            {
                DaoService daoService = new DaoService(connection);

                TimeCalculator timeCalculator = new TimeCalculator();
                timeCalculator.setStart(System.currentTimeMillis());
                List<Page> pages = daoService.getPages(query);
                timeCalculator.setEnd(System.currentTimeMillis());

                request.setAttribute("pages", pages);
                request.setAttribute("query", query);
                request.setAttribute("timeTakenToFindPages", timeCalculator.getElapsedTime());

                String file = "BackToIndex.html";
                request.setAttribute(file.replace(".html", ""), new HTMLReader(file).getFormAsContent());
                request.getRequestDispatcher("views/DisplaySearchResults.jsp").forward(request, response);
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
            catch (ServletException ex)
            {
                request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
            }
            catch (IOException ex)
            {
                request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
            }
            catch (Exception ex)
            {
                request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
            }
        }
    }
}
