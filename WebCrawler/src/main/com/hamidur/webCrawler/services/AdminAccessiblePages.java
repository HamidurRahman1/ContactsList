package com.hamidur.webCrawler.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminAccessiblePages
{
    public static boolean validateAdminAccessiblePages(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        HttpSession session = request.getSession(false);

//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("Cache-Control","no-store");
//        response.setHeader("Cache-Control","must-revalidate");
//        response.setHeader("Pragma","no-cache");

        if(session.getAttribute(Attributes.admin.toString()) == null)
        {
            session.setAttribute("403", "Requested URL is only accessible by an admin.");
            SessionManager.loadGeneralPagesToSession(session);
            return false;
        }
        else return true;
    }
}
