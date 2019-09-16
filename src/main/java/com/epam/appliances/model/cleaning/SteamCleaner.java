package com.epam.appliances.model.cleaning;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;

import static com.epam.appliances.model.AppliancePurpose.CLEANING;

public class SteamCleaner extends Appliance {

    public SteamCleaner(String title, int power, int weight, Color color) {
        super(title, CLEANING, power, weight, color);
    }

}
