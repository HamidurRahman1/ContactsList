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
//        String file = new File("").getPath()+"/src/main/webapp/forms/";
//        Document document = Jsoup.parse(new File("./"+file+htmlFileName), "utf-8");
//        this.content = document.getElementsByTag("form").first();
//    }

    public HTMLReader(String htmlFileName) throws IOException
    {
        this.document = Jsoup.parse(new File
                ("/Users/hamidurrahman/Downloads/CS/Java-WS/Web/WebCrawler/src/main/webapp/forms/"+htmlFileName), "utf-8");
    }

    public Element getFormAsContent() {
        return document.getElementsByTag("form").first();
    }

    public Element getBody()
    {
        return document.body();
    }
}
