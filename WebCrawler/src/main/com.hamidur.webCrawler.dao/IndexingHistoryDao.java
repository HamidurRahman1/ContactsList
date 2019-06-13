package com.hamidur.webCrawler.dao;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.util.DBUtilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IndexingHistoryDao
{
    private Connection connection;

    public IndexingHistoryDao(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(IndexingHistory indexingHistory) throws SQLIntegrityConstraintViolationException, SQLException
    {
        final String sql = "Insert into Indexed_Pages(adminId, pageId, date) values(?, ?, ?)";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            for(Page page : indexingHistory.getIndexedPages())
            {
                if(!isExist(page.getPageId(), indexingHistory.getAdmin().getAdminId(),
                        DBUtilities.localDateToSqlDate(indexingHistory.getDate())))
                {
                    preparedStatement.setInt(1, indexingHistory.getAdmin().getAdminId());
                    preparedStatement.setInt(2, page.getPageId());
                    preparedStatement.setDate(3, DBUtilities.localDateToSqlDate(indexingHistory.getDate()));
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch (SQLIntegrityConstraintViolationException ex)
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
    }

    public boolean isExist(int adminId, int pageId, Date date) throws SQLException
    {
        final String sql = "Select adminId, pageId, date from Indexed_Pages " +
                "where adminId=? and pageId=? and date=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, adminId);
            preparedStatement.setInt(2, pageId);
            preparedStatement.setDate(3, date);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                return resultSet.next();
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw ex;
        }
        return true;
    }

    public List<IndexingHistory> getAll() throws SQLException
    {
        final String sql = "select adminId, url, date from Indexed_Pages, Pages where Pages.pageId=Indexed_Pages.pageId";
        List<IndexingHistory> indexingHistories = new LinkedList<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    IndexingHistory indexingHistory = new IndexingHistory();
                    Admin admin = new Admin();
                    Page page = new Page();
                    admin.setAdminId(resultSet.getInt(1));
                    page.setUrl(resultSet.getString(2));
                    indexingHistory.setDate(resultSet.getDate(3).toLocalDate());
                    indexingHistory.setAdmin(admin);
                    indexingHistory.setIndexedPages(new HashSet<>(Set.of(page)));
                    indexingHistories.add(indexingHistory);
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw ex;
        }
        return indexingHistories;
    }
}
