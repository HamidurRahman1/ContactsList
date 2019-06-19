package com.hamidur.webCrawler.models;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.hamidur.webCrawler.services.TimeCalculator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler
{
    private String url;
    private Set<String> crawledLinks;
    private float timeTakenToFindLinks;
    private int depth;
    private int linksToCrawl;

    private static final int MIN_LINKS_TO_CRAWL = 0;
    private static final int MIN_DEPTH = 0;
    private static final int MAX_LINKS_TO_CRAWL = 5;
    private static final int MAX_DEPTH = 2;

    public WebCrawler(String url, int linksToCrawl, int depth)
    {
        crawledLinks = new LinkedHashSet<>();
        setUrl(url);
        setLinksToCrawl(linksToCrawl);
        setDepth(depth);
    }

    public void crawl() throws IOException, Exception
    {
        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.setStart(System.currentTimeMillis());
        if(getLinksToCrawl() <= MIN_LINKS_TO_CRAWL)
        {
            this.crawledLinks.add(this.url);
        }
        else
        {
            this.crawledLinks.add(this.url);
            getChildLinks(this.url, MIN_DEPTH-1);
        }
        timeCalculator.setEnd(System.currentTimeMillis());
        timeTakenToFindLinks = timeCalculator.getElapsedTime();
    }

    private void getChildLinks(String link, int layer) throws IOException
    {
        if(layer >= getDepth())
        {
            return;
        }
        else
        {
            layer++;
            Document document = Jsoup.connect(link).get();
            Elements totalLinks = document.select("a[href]");

            int eachLinkInParent = 0;
            int linksToExtract = 1;
            while (linksToExtract <= getLinksToCrawl())
            {
                Element page = totalLinks.get(eachLinkInParent++);
                String l = page.attr( "abs:href");
                if(!crawledLinks.contains(l))
                {
                    crawledLinks.add(l);
                    linksToExtract++;
                    getChildLinks(link, layer);
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getCrawledLinks() {
        return crawledLinks;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        if(depth <= getMinDepth())
        {
            this.depth = getMinDepth();
        }
        else if(depth >= getMaxDepth())
        {
            this.depth = getMaxDepth();
        }
        else
        {
            this.depth = depth;
        }
    }

    public float getTimeTakenToFindLinks() {
        return timeTakenToFindLinks;
    }

    public int getLinksToCrawl() {
        return linksToCrawl;
    }

    public void setLinksToCrawl(int linksToCrawl)
    {
        if(linksToCrawl <= getMinLinksToCrawl())
        {
            this.linksToCrawl = getMinLinksToCrawl();
        }
        else if(linksToCrawl >= getMaxLinksToCrawl())
        {
            this.linksToCrawl = getMaxLinksToCrawl();
        }
        else
        {
            this.linksToCrawl = linksToCrawl;
        }
    }

    public static int getMinLinksToCrawl() {
        return MIN_LINKS_TO_CRAWL;
    }

    public static int getMinDepth() {
        return MIN_DEPTH;
    }

    public static int getMaxLinksToCrawl() {
        return MAX_LINKS_TO_CRAWL;
    }

    public static int getMaxDepth() {
        return MAX_DEPTH;
    }

    @Override
    public String toString()
    {
        return "WebCrawler [url=" + url + ", depth=" + depth + ", linksToCrawl=" + linksToCrawl + "]";
    }
}