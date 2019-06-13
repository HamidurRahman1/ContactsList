package com.hamidur.webCrawler.services;

import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.util.DBUtilities;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginValidatorService
{
    public LoginValidatorService() {}

    public Admin verifyLogin(String userName, String password) throws ClassNotFoundException, SQLException
    {
        try(Connection connection = DBUtilities.getConnection())
        {
            DaoService daoService = new DaoService(connection);
            Admin admin = daoService.getAdmin(userName);

            if(admin != null && admin.getUserName().equals(userName)
                    && admin.getPassword().equals(password)) return admin;
            else return null;
        }
    }
}
