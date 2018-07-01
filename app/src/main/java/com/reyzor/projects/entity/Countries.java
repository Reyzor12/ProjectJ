package com.reyzor.projects.entity;

public class Countries
{
    private String name;
    private String climate;
    private Integer cost;
    private Boolean hasBeach;
    private Float coordX;
    private Float coordY;
    private String description;
    private Integer imageId;

    public Countries(String name, String climate, Integer cost, Boolean hasBeach, Float coordX, Float coordY, String description, Integer imageId) {
        this.name = name;
        this.climate = climate;
        this.cost = cost;
        this.hasBeach = hasBeach;
        this.coordX = coordX;
        this.coordY = coordY;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Boolean getHasBeach() {
        return hasBeach;
    }

    public void setHasBeach(Boolean hasBeach) {
        this.hasBeach = hasBeach;
    }

    public Float getCoordX() {
        return coordX;
    }

    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }

    public Float getCoordY() {
        return coordY;
    }

    public void setCoordY(Float coordY) {
        this.coordY = coordY;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
