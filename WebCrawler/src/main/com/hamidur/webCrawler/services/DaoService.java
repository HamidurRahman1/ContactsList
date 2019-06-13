package com.hamidur.webCrawler.services;

import com.hamidur.webCrawler.dao.AdminDao;
import com.hamidur.webCrawler.dao.IndexingHistoryDao;
import com.hamidur.webCrawler.dao.PageDao;
import com.hamidur.webCrawler.dao.PageWordDao;
import com.hamidur.webCrawler.dao.QueryDao;
import com.hamidur.webCrawler.dao.SearchHistoryDao;
import com.hamidur.webCrawler.dao.WordDao;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.models.SearchHistory;
import com.hamidur.webCrawler.models.Word;
import com.hamidur.webCrawler.util.DBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaoService
{
    private Connection connection;

    public DaoService(Connection connection)
    {
        this.connection = connection;
    }

    public Admin getAdmin(String userName) throws SQLException
    {
        AdminDao adminDao = new AdminDao(this.connection);
        return adminDao.getAdmin(userName);
    }

    public Set<Page> insertPages(Set<Page> pages) throws SQLIntegrityConstraintViolationException, SQLException
    {
        PageDao pageDao = new PageDao(connection);
        return pageDao.insertPages(pages);
    }

    public boolean insertPage(Page page) throws SQLIntegrityConstraintViolationException, SQLException
    {
        PageDao pageDao = new PageDao(connection);
        return pageDao.insertPage(page);
    }

    public Page getPageByUrl(String url) throws SQLException
    {
        PageDao pageDao = new PageDao(connection);
        return pageDao.getPageByUrl(url);
    }

    public List<Page> getPages(String query) throws SQLException
    {
        List<Page> pages = new LinkedList<>();

        try(Connection connection = DBUtilities.getConnection();)
        {
            QueryDao queryDao = new QueryDao(connection);
            TimeCalculator timeCalculator = new TimeCalculator();

            timeCalculator.setStart(System.currentTimeMillis());
            pages = queryDao.getPages(query);
            timeCalculator.setEnd(System.currentTimeMillis());

            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setQuery(query);
            searchHistory.setTotalResultsFound(pages.size());
            searchHistory.setTimeTakenToFindResults(timeCalculator.getElapsedTime());
            searchHistory.setDate(LocalDate.now());

            this.insertSearchHistory(searchHistory);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw ex;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw ex;
        }
        return pages;
    }

    public boolean insertWord(Word word) throws SQLIntegrityConstraintViolationException, SQLException
    {
        WordDao wordDao = new WordDao(connection);
        return wordDao.insertWord(word);
    }

    public Set<Word> insertWords(Set<Word> words) throws SQLIntegrityConstraintViolationException, SQLException
    {
        WordDao wordDao = new WordDao(connection);
        return wordDao.insertWordsSet(words);
    }

    public Word getWordObject(String word) throws SQLException
    {
        WordDao wordDao = new WordDao(connection);
        return wordDao.getWordObjByWord(word);
    }

    public void insertPageWords(Page page, Set<Word> wordsToInsert, Map<Word, Integer> wordFrequency)
            throws SQLException, SQLIntegrityConstraintViolationException
    {
        PageWordDao pageWordDao = new PageWordDao(connection);
        pageWordDao.insertPageWords(page, wordsToInsert, wordFrequency);
    }

    public void insertIndexingHistory(IndexingHistory indexingHistory)
            throws SQLIntegrityConstraintViolationException, SQLException
    {
        IndexingHistoryDao indexingHistoryDao = new IndexingHistoryDao(this.connection);
        indexingHistoryDao.insert(indexingHistory);
    }

    public List<IndexingHistory> getAllIndexingHistories() throws SQLException
    {
        IndexingHistoryDao indexingHistoryDao = new IndexingHistoryDao(this.connection);
        return indexingHistoryDao.getAll();
    }

    public void insertSearchHistory(SearchHistory searchHistory) throws SQLIntegrityConstraintViolationException, SQLException
    {
        SearchHistoryDao searchHistoryDao = new SearchHistoryDao(connection);
        searchHistoryDao.insert(searchHistory);
    }

    public List<SearchHistory> getAllSearchHistories() throws SQLException
    {
        SearchHistoryDao searchHistoryDao = new SearchHistoryDao(connection);
        return searchHistoryDao.getAll();
    }

    public void closeConnection() throws SQLException
    {
        DBUtilities.closeConnection();
    }

}
