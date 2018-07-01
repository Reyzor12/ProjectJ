package com.reyzor.projects.data;

import com.reyzor.projects.R;
import com.reyzor.projects.entity.Countries;

public class DataBase
{
    private static String[] climate = {"жаркий", "умеренный", "холодный"};
    private static Countries[] countries =
    {
        new Countries("Russia", "холодный", 25000, false, 20f, 20f, "FDSLFJDSLFJSDLJFLFDLSJFDS", R.drawable.usa),
        new Countries("USA", "умеренный", 80000, true, 50f, 50f, "FDSdsfsdbddfgf", R.drawable.usa)
    };

    public static String[] getClimate()
    {
        return climate;
    }
    public static Countries[] getCountries() { return countries; }
}
