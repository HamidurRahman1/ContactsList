package com.hamidur.webCrawler.dao;

import com.hamidur.webCrawler.models.SearchHistory;
import com.hamidur.webCrawler.util.DBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.List;

public class SearchHistoryDao
{
    private Connection connection;

    public SearchHistoryDao (Connection connection)
    {
        this.connection = connection;
    }

    public void insert(SearchHistory searchHistory) throws SQLException
    {
        final String sql = "Insert into Search_History(query, totalResults, timeTaken, date) values(?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, searchHistory.getQuery());
            preparedStatement.setInt(2, searchHistory.getTotalResultsFound());
            preparedStatement.setFloat(3, searchHistory.getTimeTakenToFindResults());
            preparedStatement.setDate(4, DBUtilities.localDateToSqlDate(searchHistory.getDate()));
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex)
        {
//            throw ex;
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<SearchHistory> getAll() throws SQLException
    {
        List<SearchHistory> searchHistories = new LinkedList<>();
        final String sql = "select query, totalResults, timeTaken, date from Search_History";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    SearchHistory searchHistory = new SearchHistory();
                    searchHistory.setQuery(resultSet.getString(1));
                    searchHistory.setTotalResultsFound(resultSet.getInt(2));
                    searchHistory.setTimeTakenToFindResults(resultSet.getFloat(3));
                    searchHistory.setDate(resultSet.getDate(4).toLocalDate());
                    searchHistories.add(searchHistory);
                }
                return searchHistories;
            }
        }
        catch (SQLException ex)
        {
//            throw ex;
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return searchHistories;
    }
}
