package com.hamidur.cunyfirst.models.dbModels;

public enum CourseName
{
    BTA("BTA"), ENG("ENG"), ESL("ESL"),
    HUP("HUP"), HUC("HUC"), HUA("HUA"),
    MAT("MAT"), MAC("MAC"), SCB("SCB"),
    SCC("SCC"), SCP("SCP"), SSY("SSY");
    
    private final String value;
    
    CourseName(final String newValue)
    {
        value = newValue;
    }
    
    public String getValue()
    {
        return value.toUpperCase();
    }
}
