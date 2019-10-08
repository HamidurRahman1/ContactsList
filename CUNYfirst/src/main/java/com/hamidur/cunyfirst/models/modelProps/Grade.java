package com.hamidur.cunyfirst.models.modelProps;

public enum Grade
{
    A_PLUS("A+"), A("A"), A_MINUS("A-"),
    B_PLUS("B+"), B("B"), B_MINUS("B-"),
    C_PLUS("C+"), C("C"), C_MINUS("C-"),
    D_PLUS("D+"), D("D"), D_MINUS("D-"),

    PASS("P"),
    SATISFACTORY("S"),
    UNSATISFACTORY("U"),

    REPEAT("R"),

    WU("WU"), W("W"),
    WN("WN"), INC("INC"),

    WAVED("@");

    private final String value;

    Grade(final String newValue)
    {
        value = newValue;
    }

    public String getValue()
    {
        return value;
    }
}
