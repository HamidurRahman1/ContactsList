package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.models.ExtractData;
import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.models.WebCrawler;
import com.hamidur.webCrawler.models.Word;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.services.TimeCalculator;
import com.hamidur.webCrawler.services.URLValidator;
import com.hamidur.webCrawler.util.DBUtilities;

@WebServlet(urlPatterns = {"/crawl"})
public class Crawler extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        redirectIfNotValidSession(request, response);
        try
        {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            String url = request.getParameter("url");
            int linksToCrawl = Integer.parseInt(request.getParameter("linksToCrawl"));
            int maxDepth = Integer.parseInt(request.getParameter("maxDepth"));

            URLValidator urlValidator = new URLValidator(url);

            if(urlValidator.isValid())
            {
                WebCrawler webCrawler = new WebCrawler(urlValidator.getUrl(), linksToCrawl, maxDepth);
                webCrawler.crawl();

                ExtractData extractData = new ExtractData(webCrawler.getCrawledLinks());

                TimeCalculator timeCalculator = new TimeCalculator();
                timeCalculator.setStart(System.currentTimeMillis());
                Set<Page> insertedPages = insertIntoDatabase(admin, extractData.getLinksData(), request, response);
                timeCalculator.setEnd(System.currentTimeMillis());

                request.getSession().setAttribute("timeTakenToInsert", timeCalculator.getElapsedTime());
                request.getSession().setAttribute("timeToFindLinks", webCrawler.getTimeTakenToFindLinks());
                request.getSession().setAttribute("timeToFindWords", extractData.getTimeTakenToExtractData());
                request.getSession().setAttribute("pages", insertedPages);

                request.getRequestDispatcher("views/CrawledData.jsp").forward(request, response);
            }
        }
        catch (ClassCastException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (ProtocolException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (UnknownHostException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (ConnectException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (NullPointerException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (NumberFormatException ex)
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

    private Set<Page> insertIntoDatabase
            (Admin admin, TreeMap<String, Page> linksPages, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try(Connection connection = DBUtilities.getConnection())
        {
            DaoService daoService = new DaoService(connection);

            Set<Page> insertedPages = daoService.insertPages(new LinkedHashSet<>(linksPages.values()));

            for(Page page : insertedPages)
            {
                Set<Word> insertedWords = daoService.insertWords(page.getWordFrequency().keySet());
                daoService.insertPageWords(page, insertedWords, page.getWordFrequency());
            }

            IndexingHistory indexingHistory = new IndexingHistory();
            indexingHistory.setAdmin(admin);
            indexingHistory.setIndexedPages(insertedPages);
            indexingHistory.setDate(LocalDate.now());

            daoService.insertIndexingHistory(indexingHistory);
            return insertedPages;
        }
        catch (ClassNotFoundException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (SQLIntegrityConstraintViolationException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        catch (SQLException ex)
        {
            request.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            request.getRequestDispatcher("errors/DisplayErrors.jsp").forward(request, response);
        }
        return null;
    }

    private void redirectIfNotValidSession(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getSession().getAttribute("admin") == null)
        {
            response.sendRedirect("index.jsp");
        }
    }
}
