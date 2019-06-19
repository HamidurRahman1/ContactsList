package com.hamidur.webCrawler.models;

import java.time.LocalDate;

public class SearchHistory
{
    private int searchId;
    private String query;
    private int totalResultsFound;
    private float timeTakenToFindResults;
    private LocalDate localDate;

    public SearchHistory() {}

    public SearchHistory(int searchId, String query, int totalResultsFound)
    {
        this(searchId, query, totalResultsFound, 0, LocalDate.now());
    }

    public SearchHistory(int searchId, String query, int totalResultsFound, float timeTakenToFindResults)
    {
        this(searchId, query, totalResultsFound, timeTakenToFindResults, LocalDate.now());
    }

    public SearchHistory(int searchId, String query, int totalResultsFound, float timeTakenToFindResults, LocalDate localDate)
    {
        setSearchId(searchId);
        setQuery(query);
        setTotalResultsFound(totalResultsFound);
        setTimeTakenToFindResults(timeTakenToFindResults);
        setDate(localDate);
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getTotalResultsFound() {
        return totalResultsFound;
    }

    public void setTotalResultsFound(int totalResultsFound) {
        this.totalResultsFound = totalResultsFound;
    }

    public float getTimeTakenToFindResults() {
        return timeTakenToFindResults;
    }

    public void setTimeTakenToFindResults(float timeTakenToFindResults) { this.timeTakenToFindResults = timeTakenToFindResults; }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate date) {
        this.localDate = date;
    }

    @Override
    public String toString()
    {
        return "SearchHistory{" +
                "searchId=" + searchId +
                ", query='" + query + '\'' +
                ", totalResultsFound=" + totalResultsFound +
                ", timeTakenToFindResults=" + timeTakenToFindResults +
                ", localDate=" + localDate +
                '}';
    }
}
