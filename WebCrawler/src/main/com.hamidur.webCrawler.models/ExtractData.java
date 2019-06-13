package com.hamidur.webCrawler.models;

import com.hamidur.webCrawler.services.TimeCalculator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExtractData
{
    private TreeMap<String, Page> linksData;
    private float timeTakenToExtractData;

    private static final String DELIMITERS = "[\\s\\W]+";

    public ExtractData(Set<String> links) throws IOException
    {
        linksData = new TreeMap<>();
        doExtracting(links);
    }

    public TreeMap<String, Page> getLinksData()
    {
        return linksData;
    }

    public float getTimeTakenToExtractData()
    {
        return timeTakenToExtractData;
    }

    private void doExtracting(Set<String> links) throws IOException
    {
        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.setStart(System.currentTimeMillis());
        for(String link: links)
        {
            try
            {
                Page page = new Page();
                Document document = Jsoup.connect(link)
                                        .ignoreHttpErrors(true)
                                        .maxBodySize(0)
                                        .timeout(0)
                                        .get();

                page.setTitle(document.title());
                page.setUrl(document.baseUri());
                try
                {
                    String description = document.select("meta[name=description]").first().attr("content");
                    page.setDescription(description);
                }
                catch (NullPointerException ex)
                {
                    extractWords(page, document);
                    linksData.put(page.getUrl(), page);
                }

                if(!linksData.containsKey(page.getUrl()))
                {
                    extractWords(page, document);
                    linksData.put(page.getUrl(), page);
                }
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
//                throw new IOException("Exception occurred opening - " + link + " - link.");
            }
            catch (NullPointerException ex)
            {
                throw new NullPointerException(ex.getMessage());
            }
        }
        timeCalculator.setEnd(System.currentTimeMillis());
        timeTakenToExtractData = timeCalculator.getElapsedTime();
    }

    private void extractWords(Page page, Document document)
    {
        int start = 0;
        int end = 350;
        String body = document.body().text().trim().toLowerCase();

        if(page.getDescription() == null || page.getDescription().isEmpty())
        {
            if(body.length() >= end) page.setDescription(body.substring(start, end));
            else page.setDescription(body.substring(start, body.length()-1));
        }

        String words[] = body.split(DELIMITERS);
        Map<Word, Integer> wordFrequency = new LinkedHashMap<>();

        for(String word: words)
        {
            Word wordObj = new Word(word);
            Integer count = wordFrequency.get(wordObj);
            if(count == null) wordFrequency.put(wordObj, 1);
            else wordFrequency.put(wordObj, ++count);
        }
        page.setWordFrequency(wordFrequency);
    }
}