package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.services.Attributes;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.services.SessionManager;
import com.hamidur.webCrawler.services.TimeCalculator;
import com.hamidur.webCrawler.util.DBUtilities;

@WebServlet(urlPatterns = {"/queryTheSearch"})
public class SearchQuery extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        try
        {
            SessionManager.loadGeneralPagesToSession(session);
            if (query.trim().isEmpty())
            {
                if (session.getAttribute(Attributes.admin.toString()) != null)
                    response.sendRedirect("views/AdminAccess.jsp");
                else response.sendRedirect("index.jsp");
            }
            else {
                try (Connection connection = DBUtilities.getConnection()) {
                    DaoService daoService = new DaoService(connection);

                    TimeCalculator timeCalculator = new TimeCalculator();
                    timeCalculator.setStart(System.currentTimeMillis());
                    List<Page> pages = daoService.getPages(query);
                    timeCalculator.setEnd(System.currentTimeMillis());

                    session.setAttribute(Attributes.pages.toString(), pages);
                    session.setAttribute(Attributes.query.toString(), query);
                    session.setAttribute(Attributes.timeTakenToFindPages.toString(), timeCalculator.getElapsedTime());

                    response.sendRedirect("views/DisplaySearchResults.jsp");
                } catch (ClassNotFoundException ex) {
                    session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                    response.sendRedirect("errors/DisplayErrors.jsp");
                } catch (SQLException ex) {
                    session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                    response.sendRedirect("errors/DisplayErrors.jsp");
                } catch (IOException ex) {
                    session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                    response.sendRedirect("errors/DisplayErrors.jsp");
                } catch (Exception ex) {
                    session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                    response.sendRedirect("errors/DisplayErrors.jsp");
                }
            }

        }
        catch (IOException ex) {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        } catch (Exception ex) {
            session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
    }
}
