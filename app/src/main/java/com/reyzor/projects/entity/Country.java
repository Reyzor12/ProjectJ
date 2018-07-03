package com.reyzor.projects.entity;

/**
 * Definition of country.
 *
 */

public interface Country extends BaseEntity
{
    String getName();
    void setName(String name);
    CountryDescription getCountryDescription();
    void setCountryDescription(CountryDescription description);
    CountryFilter getCountryFilter();
    void setCountryFilter(CountryFilter filter);
    Integer getImage();
    void setImage(Integer image);
}
