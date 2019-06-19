package com.hamidur.webCrawler.dao;

import com.hamidur.webCrawler.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao
{
    private Connection connection;

    public AdminDao(Connection connection)
    {
        this.connection = connection;
    }

    public Admin getAdmin(String userName) throws SQLException
    {
        Admin admin = null;
        final String sql = "select adminId, userName, password, firstName, lastName from Admin where userName like ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, userName);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                if(resultSet.next())
                {
                    if(userName.equals(resultSet.getString(2)))
                    {
                        admin = new Admin();
                        admin.setAdminId(Integer.parseInt(resultSet.getString(1)));
                        admin.setUserName(resultSet.getString(2));
                        admin.setPassword(resultSet.getString(3));
                        admin.setFirstName(resultSet.getString(4));
                        admin.setLastName(resultSet.getString(5));
                        return admin;
                    }
                }
            }
        }
        return admin;
    }
}
