package com.hamidur.webCrawler.models;

import com.linkedin.urls.Url;
import com.linkedin.urls.detection.UrlDetector;
import com.linkedin.urls.detection.UrlDetectorOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Page
{
    private int pageId;
    private String url;
    private String title;
    private String description;
    private Map<Word, Integer> wordFrequency;

    public Page() {}

    public Page(String url)
    {
        setUrl(url);
    }

    public Page(String url, String title, String description)
    {
        this(url, title, description, new HashMap<>());
    }

    public Page(String url, String title, String description, Map<Word, Integer> wordFrequency)
    {
        setUrl(url);
        setTitle(title);
        setDescription(description);
        setWordFrequency(wordFrequency);
    }

    public Map<Word, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<Word, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        Page page = (Page) o;
        String thisHostPath = getHostAndPath(this.getUrl());
        String thatHostPath = getHostAndPath(page.getUrl());
        return thisHostPath.equals(thatHostPath);
    }

    private String getHostAndPath(String url)
    {
        UrlDetector parser = new UrlDetector(url, UrlDetectorOptions.Default);
        Url link = parser.detect().get(0);
        String host = link.getHost().replace("www.", "");
        String path = link.getPath().replace(link.getFragment(), "");
        if (path.endsWith("/")) path = path.substring(0, path.length()-1);
        return host+path;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl());
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", wordFrequency=" + wordFrequency +
                '}';
    }
}
