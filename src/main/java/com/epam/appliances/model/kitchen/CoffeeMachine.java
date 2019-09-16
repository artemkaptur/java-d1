package com.epam.appliances.model.kitchen;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;

import static com.epam.appliances.model.AppliancePurpose.KITCHEN;

public class CoffeeMachine extends Appliance {

    public CoffeeMachine(String title, int power, int weight, Color color) {
        super(title, KITCHEN, power, weight, color);
    }

}
