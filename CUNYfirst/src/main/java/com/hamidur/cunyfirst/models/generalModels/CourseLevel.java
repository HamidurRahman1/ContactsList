package com.hamidur.cunyfirst.models.generalModels;

public enum CourseLevel
{
    Level_101("101"), Level_102("102"), Level_103("103"), Level_106("106"),
    Level_110("110"), Level_115("115"), Level_200("200"), Level_201("201"),
    Level_202("202"), Level_210("210"), Level_231("231"), Level_235("235"),
    Level_270("270"), Level_281("281"), Level_283("283"), Level_286("286");

    private final String value;

    CourseLevel(final String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
