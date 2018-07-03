package com.reyzor.projects.entity;

import java.util.ArrayList;
import java.util.List;

public class CountryDescriptionImp implements CountryDescription
{
    private Long id;
    private Integer price;
    private String text;
    private List<Integer> images;
    private CountryCoordinate coordinate;

    public CountryDescriptionImp(Long id)
    {
        this.id = id;
        this.images = new ArrayList<>();
    }

    public CountryDescriptionImp(Long id, Integer price, String text, List<Integer> images, CountryCoordinate coordinate)
    {
        this.id = id;
        this.price = price;
        this.text = text;
        this.images = images == null ? new ArrayList<Integer>() : images;
        this.coordinate = coordinate;
    }

    @Override
    public String getTextDescription()
    {
        return text;
    }

    @Override
    public void setTextDescription(String text)
    {
        this.text = text;
    }

    @Override
    public List<Integer> getImageDescription()
    {
        return images;
    }

    @Override
    public void addImageDescription(Integer image)
    {
        images.add(image);
    }

    @Override
    public void clearImageDescription()
    {
        images.clear();
    }

    @Override
    public List<Integer> setImageDescription(List<Integer> images)
    {
        images.clear();
        images.addAll(images);
        return images;
    }

    @Override
    public CountryCoordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(CountryCoordinate coordinate)
    {
        this.coordinate = coordinate;
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
