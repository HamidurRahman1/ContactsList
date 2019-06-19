package com.hamidur.webCrawler.controllers;

import java.io.IOException;
import java.net.ConnectException;
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
import javax.servlet.http.HttpSession;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.models.ExtractData;
import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.models.WebCrawler;
import com.hamidur.webCrawler.models.Word;
import com.hamidur.webCrawler.services.AdminAccessiblePages;
import com.hamidur.webCrawler.services.Attributes;
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
        if(AdminAccessiblePages.validateAdminAccessiblePages(request, response))
        {
            HttpSession session = request.getSession(false);
            try
            {
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
                    Set<Page> insertedPages =
                            insertIntoDatabase((Admin) session.getAttribute(Attributes.admin.toString()),
                                    extractData.getLinksData(), request, response);
                    timeCalculator.setEnd(System.currentTimeMillis());

                    session.setAttribute(Attributes.timeTakenToInsert.toString(), timeCalculator.getElapsedTime());
                    session.setAttribute(Attributes.timeTakenToFindLinks.toString(), webCrawler.getTimeTakenToFindLinks());
                    session.setAttribute(Attributes.timeTakenToFindWords.toString(), extractData.getTimeTakenToExtractData());
                    session.setAttribute(Attributes.crawledPages.toString(), insertedPages);

                    response.sendRedirect("views/CrawledData.jsp");
                }
            }
            catch (ClassCastException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (ProtocolException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (UnknownHostException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (ConnectException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (NullPointerException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (NumberFormatException ex)
            {
                session.setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
                response.sendRedirect("errors/DisplayErrors.jsp");
            }
            catch (ServletException ex)
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
        else
        {
            response.sendRedirect("../errors/DisplayErrors.jsp");
        }
    }

    private Set<Page> insertIntoDatabase
            (Admin admin, TreeMap<String, Page> linksPages, HttpServletRequest request, HttpServletResponse response)
            throws IOException
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
            request.getSession(false).setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (SQLIntegrityConstraintViolationException ex)
        {
            request.getSession(false).setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (SQLException ex)
        {
            request.getSession(false).setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        catch (Exception ex)
        {
            request.getSession(false).setAttribute(String.valueOf(ex.hashCode()), ex.getMessage());
            response.sendRedirect("errors/DisplayErrors.jsp");
        }
        return null;
    }
}
