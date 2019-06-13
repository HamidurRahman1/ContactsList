package com.hamidur.webCrawler.models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class IndexingHistory
{
    private Admin admin;
    private Set<Page> indexedPages;
    private LocalDate localDate;

    public IndexingHistory() {}

    public IndexingHistory(Admin admin, Set<Page> indexedPages, LocalDate localDate) {
        setAdmin(admin);
        setIndexedPages(indexedPages);
        setDate(localDate);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Set<Page> getIndexedPages() {
        return indexedPages;
    }

    public void setIndexedPages(Set<Page> indexedPages) {
        this.indexedPages = indexedPages;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate date) {
        this.localDate = date;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof IndexingHistory)) return false;
        IndexingHistory that = (IndexingHistory) o;
        return ((getAdmin().getAdminId() == getAdmin().getAdminId()) &&
                (getIndexedPages().containsAll(that.getIndexedPages()) && that.getIndexedPages().containsAll(getIndexedPages()))
                        && localDate.equals(that.localDate));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdmin(), getIndexedPages(), localDate);
    }

    @Override
    public String toString()
    {
        return "IndexingHistory{" +
                "admin=" + admin +
                ", indexedPages=" + indexedPages +
                ", localDate=" + localDate +
                '}';
    }
}
