package com.hamidur.webCrawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.hamidur.webCrawler.models.Page;

public class QueryDao
{
    private Connection connection;

    public QueryDao(Connection connection)
    {
        this.connection = connection;
    }

    public List<Page> getPages(String query) throws SQLException
    {
        List<Page> pages = new LinkedList<>();
        query = query.trim().toLowerCase();
        String words[] = query.split(" ");
        StringBuilder wordLike = new StringBuilder("word like ");

        for(String queryPart : words) wordLike.append("? or word like ");
        wordLike.replace(0, wordLike.length(), wordLike.toString().substring(0, wordLike.toString().length()-14));

        String sql =
                "Select title, url, description from Pages where pageId in " +
                        "(select distinct pageId from Pages_Words where wordId in " +
                        "(select wordId from Words where (" + wordLike.toString() + ")) " +
                        "order by frequency desc)";

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            int i = 1;
            for(String word: words) preparedStatement.setString(i++, word);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    Page page = new Page();
                    page.setTitle(resultSet.getString(1));
                    page.setUrl(resultSet.getString(2));
                    page.setDescription(resultSet.getString(3));
                    pages.add(page);
                }
            }
        }
        return pages;
    }
}
