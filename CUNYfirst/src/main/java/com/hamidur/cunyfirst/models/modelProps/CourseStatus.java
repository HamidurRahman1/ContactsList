package com.hamidur.cunyfirst.models.modelProps;

public enum CourseStatus
{
    IN_PROGRESS("INP"),
    TAKEN("TKN"),
    TRANSFERRED("TRN");

    private final String value;

    CourseStatus(final String newValue)
    {
        value = newValue;
    }

    public String getValue()
    {
        return value.toUpperCase();
    }
}
