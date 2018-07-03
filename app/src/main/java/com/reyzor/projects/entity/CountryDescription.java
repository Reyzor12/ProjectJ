package com.reyzor.projects.entity;

import java.util.List;

/**
 * Description of country. All specific parameters for
 * country store here.
 */

public interface CountryDescription extends BaseEntity
{
    String getTextDescription();
    void setTextDescription(String text);
    List<Integer> getImageDescription();
    void addImageDescription(Integer image);
    void clearImageDescription();
    List<Integer> setImageDescription(List<Integer> images);
    CountryCoordinate getCoordinate();
    void setCoordinate(CountryCoordinate coordinate);
}
