package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Grade;

import java.sql.Date;
import java.time.LocalDate;

public class Utility
{
    
    public static boolean isValidGrade(Grade grade)
    {
//        grade = String.valueOf(grade.charAt(0)).toUpperCase() + grade.substring(1);
//        if(grade.isEmpty()) throw new InvalidParameterException("Grade cannot be empty");
//        if(!GRADES.contains(this.grade))
//            throw new InvalidParameterException("No such grade exists");
//
        return true;
    }
    
    public static LocalDate toLocalDate(Date sqlDate)
    {
        return sqlDate.toLocalDate();
    }
    
    public static Date toSqlDate(LocalDate localDate)
    {
        return Date.valueOf(localDate);
    }
}
