package com.reyzor.projects.entity;

import java.io.Serializable;

/**
 * Interface describe coordinate of specific country.
 * Coordinates define two {@link Float} values:
 * float latitude
 * float longitude
 * */

public interface CountryCoordinate extends BaseEntity,Serializable
{
    Float getLatitude();
    void setLatitude(Float latitude);
    Float getLongitude();
    void setLongitude();
}
