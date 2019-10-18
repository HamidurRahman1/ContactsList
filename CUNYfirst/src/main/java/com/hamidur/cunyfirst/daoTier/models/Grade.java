package com.hamidur.cunyfirst.daoTier.models;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Grade
{
    private static final Set<String> GRADES = new LinkedHashSet <>
            (Arrays.asList(
                    "A+", "A", "A-",
                    "B+", "B", "B-",
                    "C+", "C", "C-",
                    "D+", "D", "D-",
                    "P", "S", "U", "R",
                    "WU", "W", "WN", "INC",
                    "@"));
    
    public static boolean contains(String grade)
    {
        grade = grade.toUpperCase();
        return GRADES.contains(grade);
    }
}