package com.reyzor.projects.data;

import com.reyzor.projects.R;
import com.reyzor.projects.entity.AdventureType;
import com.reyzor.projects.entity.Climate;
import com.reyzor.projects.entity.Country;
import com.reyzor.projects.entity.CountryCoordinateImp;
import com.reyzor.projects.entity.CountryDescriptionImp;
import com.reyzor.projects.entity.CountryFilter;
import com.reyzor.projects.entity.CountryFilterImp;
import com.reyzor.projects.entity.CountryImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryDatabaseImp implements CountryDatabase
{
    private static List<Country> countries;

    @Override
    public List<Country> getAllCountries()
    {
        if (countries == null) initCountries();
        return countries;
    }

    @Override
    public List<Country> getCountryWithFilter(CountryFilter filter)
    {
        if (countries == null) initCountries();
        return filterCountry(countries, filter);
    }

    private void initCountries()
    {
        List<Integer> austImage = new ArrayList(Arrays.asList(R.drawable.aus1, R.drawable.aus2));
        Country australia = new CountryImp(
                1l,
                "Australia",
                new CountryDescriptionImp(1l, 40000, "Австра́лия (англ. Australia, МФА: [əˈstreɪljə], от лат. austrālis — «южный»), официальная форма — Австрали́йский Сою́з (англ. Commonwealth of Australia[3], МФА: [ˈkɒm.ənˌwɛlθ əv əˈstreɪljə]) — государство в Южном полушарии, занимающее одноимённый материк, остров Тасмания и несколько других островов Индийского и Тихого океанов[* 1]",austImage , new CountryCoordinateImp(1l, 35.18f, 149.08f)),
                new CountryFilterImp(1l, true, true, Climate.WARM, true, AdventureType.EXTRIM),
                R.drawable.australia);
        countries.add(australia);
        List<Integer> chiImage = new ArrayList<>(Arrays.asList(R.drawable.chi1));
        Country china = new CountryImp(
                2l,
                "China",
                new CountryDescriptionImp(2l, 80000, "Кита́йская Наро́дная Респу́блика (КНР) (кит. трад. 中華人民共和國, упр. 中华人民共和国, пиньинь: Zhōnghuá Rénmín Gònghéguó, палл.: Чжунхуа Жэньминь Гунхэго), часто также сокращённо Кита́й (ки",chiImage , new CountryCoordinateImp(2l, 35.0f, 105.0f)),
                new CountryFilterImp(2l, false, true, Climate.MEDIUM, true, AdventureType.VACANTION),
                R.drawable.china);
        countries.add(china);
    }

    private List<Country> filterCountry(List<Country> countriesList, CountryFilter filter)
    {
        Stream<Country> countryStream = countriesList.stream();
        if (filter.hasBeach() != null)
            countryStream = countryStream.filter(country -> !country.getCountryFilter().hasBeach()^filter.hasBeach());
        if (filter.hasLowMoney() != null)
            countryStream = countryStream.filter(country -> !country.getCountryFilter().hasLowMoney()^filter.hasLowMoney());
        if (filter.getClimate() != null)
            countryStream = countryStream.filter(country -> country.getCountryFilter().getClimate().equals(filter.getClimate()));
        if (filter.isSpeakEnglish() != null)
            countryStream = countryStream.filter(country -> !country.getCountryFilter().isSpeakEnglish()^filter.isSpeakEnglish());
        if (filter.getAdventureType() != null)
            countryStream = countryStream.filter(country -> country.getCountryFilter().getAdventureType().equals(filter.getAdventureType()));
        return countryStream.collect(Collectors.toList());
    }
}
