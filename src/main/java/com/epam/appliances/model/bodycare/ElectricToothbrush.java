package com.epam.appliances.model.bodycare;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;

import static com.epam.appliances.model.AppliancePurpose.BODY_CARE;

public class ElectricToothbrush extends Appliance {

    public ElectricToothbrush(String title, int power, int weight, Color color) {
        super(title, BODY_CARE, power, weight, color);
    }

}
