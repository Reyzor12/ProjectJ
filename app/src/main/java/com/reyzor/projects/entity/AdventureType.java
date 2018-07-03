package com.reyzor.projects.entity;

public enum AdventureType
{
    VACANTION("vacantion"),
    EXTRIM("extrime");

    private String description;

    AdventureType(String desc)
    {
        this.description = desc;
    }

    String getType()
    {
        return description;
    }
}
