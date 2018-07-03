package com.reyzor.projects.entity;

/**
 * Parameter for filtering class {@link Country}
 * */

public interface CountryFilter extends BaseEntity
{
    Boolean hasBeach();
    void setBeach(Boolean beach);
    Boolean hasLowMoney();
    void setLowMoney(Boolean lowMoney);
    Climate getClimate();
    void setClimate(Climate climate);
    Boolean isSpeakEnglish();
    void setSpeakEnglish(Boolean speakEnglish);
    AdventureType getAdventureType();
    void setAdventureType(AdventureType adventureType);
}
