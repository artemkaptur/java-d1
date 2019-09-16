package com.epam.appliances.model.garden;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;

import static com.epam.appliances.model.AppliancePurpose.GARDEN;

public class LawnMower extends Appliance {

    public LawnMower(String title, int power, int weight, Color color) {
        super(title, GARDEN, power, weight, color);
    }

}
