package com.reyzor.projects.entity;

public class CountryImp implements Country
{
    private Long id;
    private String name;
    private CountryDescription description;
    private CountryFilter filter;
    private Integer image;

    public CountryImp(Long id)
    {
        this.id = id;
    }

    public CountryImp(Long id, String name, CountryDescription description, CountryFilter filter, Integer image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filter = filter;
        this.image = image;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public CountryDescription getCountryDescription()
    {
        return description;
    }

    @Override
    public void setCountryDescription(CountryDescription description)
    {
        this.description = description;
    }

    @Override
    public CountryFilter getCountryFilter()
    {
        return filter;
    }

    @Override
    public void setCountryFilter(CountryFilter filter)
    {
        this.filter = filter;
    }

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
}
