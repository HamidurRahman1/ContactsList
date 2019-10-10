package com.hamidur.cunyfirst.utils;

import java.sql.Date;
import java.time.LocalDate;

public class Utils
{
    public static LocalDate convertToLocalDate(Date sqlDate)
    {
        return sqlDate.toLocalDate();
    }

    public static Date convertToSQLDate(LocalDate localDate)
    {
        return Date.valueOf(localDate);
    }
}
