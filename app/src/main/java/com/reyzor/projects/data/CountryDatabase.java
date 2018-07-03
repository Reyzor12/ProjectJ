package com.reyzor.projects.data;

import com.reyzor.projects.entity.Country;
import com.reyzor.projects.entity.CountryFilter;

import java.util.List;

public interface CountryDatabase
{
    List<Country> getAllCountries();
    List<Country> getCountryWithFilter(CountryFilter filter);
}
