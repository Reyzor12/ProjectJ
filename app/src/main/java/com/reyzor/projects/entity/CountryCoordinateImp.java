package com.reyzor.projects.entity;

public class CountryCoordinateImp implements CountryCoordinate
{
    private Long id;
    private Float latitude;
    private Float longtitude;

    public CountryCoordinateImp(Long id)
    {
        this.id = id;
    }

    public CountryCoordinateImp(Long id, Float latitude, Float longtitude)
    {
        this.id = id;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    @Override
    public Float getLatitude()
    {
        return latitude;
    }

    @Override
    public void setLatitude(Float latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public Float getLongitude()
    {
        return this.longtitude;
    }

    @Override
    public void setLongitude()
    {
        this.longtitude = longtitude;
    }

    @Override
    public Long getId()
    {
        return this.id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
}
