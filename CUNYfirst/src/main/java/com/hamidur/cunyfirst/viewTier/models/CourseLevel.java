package com.hamidur.cunyfirst.viewTier.models;

public enum CourseLevel
{
    Level_097(97), Level_098(98), Level_099(99),
    Level_101(101), Level_102(102), Level_103(103), Level_106(106),
    Level_110(110), Level_111(111), Level_115(115), Level_125(125),
    Level_200(200), Level_201(201), Level_202(202), Level_210(210),
    Level_231(231), Level_235(235), Level_270(270), Level_281(281),
    Level_286(286);
    
    private final Integer level;
    
    CourseLevel(final Integer level)
    {
        this.level = level;
    }
    
    public Integer getValue()
    {
        return level;
    }
}
