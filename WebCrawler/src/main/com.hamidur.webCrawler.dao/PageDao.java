package com.hamidur.webCrawler.dao;

import com.hamidur.webCrawler.models.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import java.util.LinkedHashSet;
import java.util.Set;

public class PageDao
{
    private Connection connection;
    private int lastInsertedPageId;

    public PageDao(Connection connection)
    {
        this.connection = connection;
    }

    public Set<Page> insertPages(Set<Page> pages) throws SQLIntegrityConstraintViolationException, SQLException
    {
        Set<Page> insertedPages = new LinkedHashSet<>();
        final String insertPage = "insert into Pages(url, title, description) values(?, ?, ?)";

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(insertPage, Statement.RETURN_GENERATED_KEYS))
        {
            for(Page page : pages)
            {
                preparedStatement.setString(1, page.getUrl());
                preparedStatement.setString(2, page.getTitle());
                preparedStatement.setString(3, page.getDescription());

                Page isExistPage = getPageByUrl(page.getUrl());
                if(isExistPage == null)
                {
                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
                    {
                        if (generatedKeys.next())
                        {
                            this.setLastInsertedPageId(generatedKeys.getInt(1));
                            page.setPageId(getLastInsertedPageId());
                            insertedPages.add(page);
                        }
                    }
                }
                else insertedPages.add(isExistPage);
            }
        }
        catch (SQLIntegrityConstraintViolationException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw new SQLIntegrityConstraintViolationException("A url title matched with this one is already exists.");
//            throw ex;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw ex;
        }
        return insertedPages;
    }

    public boolean insertPage(Page page) throws SQLException, SQLIntegrityConstraintViolationException
    {
        final String sql = "insert into Pages(url, title, description) values(?, ?, ?)";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, page.getUrl());
            preparedStatement.setString(2, page.getTitle());
            preparedStatement.setString(3, page.getDescription());

            Page page1 = getPageByUrl(page.getUrl());
            if(page1 == null)
            {
                preparedStatement.executeUpdate();
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
                {
                    if (generatedKeys.next())
                    {
                        this.setLastInsertedPageId(generatedKeys.getInt(1));
                        page.setPageId(getLastInsertedPageId());
                        return true;
                    }
                }
            }
            else return false;
        }
        catch (SQLIntegrityConstraintViolationException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
//            throw new SQLIntegrityConstraintViolationException("A url title matched with this one is already exists.");
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
//            throw new SQLException(ex.getMessage());
        }
        return false;
    }

    public Page getPageByUrl(String url) throws SQLException
    {
        Page page = null;
        final String sql = "select pageId, url, title, description from Pages where url like ?";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, url);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                if(resultSet.next())
                {
                    page = new Page();
                    page.setPageId(resultSet.getInt(1));
                    page.setUrl(resultSet.getString(2));
                    page.setTitle(resultSet.getString(3));
                    page.setDescription(resultSet.getString(4));
                    return page;
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            throw new SQLException(ex.getMessage());
        }
        return page;
    }

    private void setLastInsertedPageId(int lastInsertedPageId)
    {
        this.lastInsertedPageId = lastInsertedPageId;
    }

    public int getLastInsertedPageId()
    {
        return lastInsertedPageId;
    }
}
