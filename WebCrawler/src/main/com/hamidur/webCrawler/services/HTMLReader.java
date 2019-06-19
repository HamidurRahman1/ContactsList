package com.hamidur.webCrawler.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class HTMLReader
{
    private Document document;

//    public HTMLReader(String htmlFileName) throws IOException
//    {
//        String filePath = Paths.get("").toString()+"src/main/webapp/forms/"+htmlFileName;
//        this.document = Jsoup.parse(new File(filePath), "utf-8");
//    }

    public HTMLReader(String htmlFileName) throws IOException
    {
        String filePath = "/Users/hamidurrahman/Downloads/CS/Java-WS/Web/WebCrawler/src/main/webapp/forms/"+htmlFileName;
        this.document = Jsoup.parse(new File(filePath), "utf-8");
    }

    public Element getFormAsContent() {
        return document.getElementsByTag("form").first();
    }

    public Element getBody()
    {
        return document.body();
    }
}
