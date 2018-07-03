package com.reyzor.projects.entity;

import java.io.Serializable;

/**
 * Climate of {@link Country}
 * use in {@link CountryFilter}
 * */

public enum Climate
{
    COLD("Cold"),
    MEDIUM("Norm"),
    WARM("Warm");

    private String description;

    Climate(String desc)
    {
        this.description = desc;
    }

    public String getClimate()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return description;
    }
}
