package com.hamidur.cunyfirst.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil
{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";
    private static final String DATABASE = "CUNYFIRST";
    private static final String SSL = "useSSL=false";
    private static final String AUTO_CONNECT = "autoReconnect=true";
    private static final String TIMEZONE = "useLegacyDatetimeCode=false&serverTimezone=America/New_York";

    private static Connection connection;

    private static Connection buildConnection() throws SQLException, ClassNotFoundException
    {
        if(connection != null && !connection.isClosed())
        {
            return connection;
        }
        else
        {
            Class.forName(DRIVER);
            String url = URL+DATABASE+"?"+TIMEZONE+"&"+AUTO_CONNECT+"&"+SSL;
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            return connection;
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if(connection != null && !connection.isClosed())
        {
            return connection;
        }
        else return buildConnection();
    }

    public static void close() throws SQLException
    {
        if(connection == null) return;
        if(!connection.isClosed()) connection.close();
    }
}
