package com.reyzor.projects.entity;

public class CountryFilterImp implements CountryFilter
{
    private Long id;
    private Boolean beach;
    private Boolean money;
    private Climate climate;
    private Boolean english;
    private AdventureType adventure;

    public CountryFilterImp(Long id)
    {
        this.id = id;
    }

    public CountryFilterImp(Long id, Boolean beach, Boolean money, Climate climate, Boolean english, AdventureType adventure)
    {
        this.id = id;
        this.beach = beach;
        this.money = money;
        this.climate = climate;
        this.english = english;
        this.adventure = adventure;
    }

    @Override
    public Boolean hasBeach() {
        return beach;
    }

    @Override
    public void setBeach(Boolean beach)
    {
        this.beach = beach;
    }

    @Override
    public Boolean hasLowMoney()
    {
        return money;
    }

    @Override
    public void setLowMoney(Boolean lowMoney)
    {
        this.money = lowMoney;
    }

    @Override
    public Climate getClimate()
    {
        return climate;
    }

    @Override
    public void setClimate(Climate climate)
    {
        this.climate = climate;
    }

    @Override
    public Boolean isSpeakEnglish()
    {
        return english;
    }

    @Override
    public void setSpeakEnglish(Boolean speakEnglish)
    {
        english = speakEnglish;
    }

    @Override
    public AdventureType getAdventureType()
    {
        return adventure;
    }

    @Override
    public void setAdventureType(AdventureType adventureType)
    {
        adventure = adventureType;
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
