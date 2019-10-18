package com.hamidur.cunyfirst.daoTier.models;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CourseLevel
{
    private static final Set<Integer> COURSE_LEVELS = new LinkedHashSet <>
            (Arrays.asList(97, 101, 102, 103, 106, 110, 111, 115, 125,
                            200, 201, 202, 210, 231, 235, 270, 281, 283, 286));
    
    public static boolean contains(Integer level)
    {
        return COURSE_LEVELS.contains(level);
    }
}
