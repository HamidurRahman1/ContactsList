package com.hamidur.webCrawler.services;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionManager
{
    private static boolean generalPagesLoaded = false;
    private static boolean adminPagesLoaded = false;

    public static void loadGeneralPagesToSession(HttpSession session) throws IOException
    {
        if(!generalPagesLoaded)
        {
            session.setAttribute(Attributes.BackToIndex.toString(),
                    new HTMLReader("BackToIndex.html").getFormAsContent());
            session.setAttribute(Attributes.AdminOption.toString(),
                    new HTMLReader("AdminOption.html").getFormAsContent());
            session.setAttribute(Attributes.SearchQueryForm.toString(),
                    new HTMLReader("SearchQueryForm.html").getFormAsContent());
            session.setAttribute(Attributes.AboutSARA.toString(),
                    new HTMLReader("AboutSARA.html").getBody());
            session.setAttribute(Attributes.LoginForm.toString(),
                    new HTMLReader("LoginForm.html").getFormAsContent());
            generalPagesLoaded = true;
        }
    }

    public static void loadAdminPagesToSession(HttpSession session) throws IOException
    {
        if(!adminPagesLoaded)
        {
            session.setAttribute(Attributes.BackToAdminAccess.toString(),
                    new HTMLReader("BackToAdminAccess.html").getFormAsContent());
            session.setAttribute(Attributes.CrawlerForm.toString(),
                    new HTMLReader("CrawlerForm.html").getFormAsContent());
            session.setAttribute(Attributes.GetAllIndexedUrls.toString(),
                    new HTMLReader("GetAllIndexedUrls.html").getFormAsContent());
            session.setAttribute(Attributes.GetAllQueries.toString(),
                    new HTMLReader("GetAllQueries.html").getBody());
            session.setAttribute(Attributes.SignOutAdmin.toString(),
                    new HTMLReader("SignOutAdmin.html").getFormAsContent());
            adminPagesLoaded = true;
        }
    }
}
