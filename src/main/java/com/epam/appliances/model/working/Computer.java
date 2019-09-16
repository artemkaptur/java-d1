package com.epam.appliances.model.working;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;

import static com.epam.appliances.model.AppliancePurpose.WORKING;

public class Computer extends Appliance {

    public Computer(String title, int power, int weight, Color color) {
        super(title, WORKING, power, weight, color);
    }

}
