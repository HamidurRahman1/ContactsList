package com.hamidur.webCrawler.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBUtilities
{
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "mysql?";
    private static final String DATABASE = "web";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String QUESTION = "?";
    private static final String AND = "&";
    private static final String SSL = "useSSL=false";
    private static final String AUTO_CONNECT = "autoReconnect=true";
    private static final String TIMEZONE = "useLegacyDatetimeCode=false&serverTimezone=America/New_York";

    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        if(connection == null || connection.isClosed())
        {
            Class.forName(getDRIVER());
            connection = DriverManager.getConnection
                    (getURL()+ getDATABASE() + getQUESTION() + getTIMEZONE() + getAND()
                                    + getAutoConnect() + getAND()+ getSSL(),
                            getUserName(), getPASSWORD());
            return connection;
        }
        return connection;
    }

    public static void closeConnection() throws SQLException
    {
        if(connection == null) return;
        if(!connection.isClosed()) connection.close();
    }

    public static String getQUESTION() {
        return QUESTION;
    }

    public static String getAND() {
        return AND;
    }

    public static String getSSL() {
        return SSL;
    }

    public static String getAutoConnect() {
        return AUTO_CONNECT;
    }

    public static String getTIMEZONE() {
        return TIMEZONE;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static String getURL() {
        return URL;
    }

    public static Date localDateToSqlDate(LocalDate localDate)
    {
        return Date.valueOf(localDate);
    }
}
