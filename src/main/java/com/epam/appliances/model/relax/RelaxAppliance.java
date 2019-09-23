package com.epam.appliances.model.relax;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.AppliancePurpose;
import com.epam.appliances.model.Color;

import java.time.LocalTime;

public abstract class RelaxAppliance extends Appliance {

    protected boolean isParentalControlOn;
    protected int timer;

    public RelaxAppliance(String title, AppliancePurpose appliancePurpose, int power, int weight, Color color) {
        super(title, appliancePurpose, power, weight, color);
        isParentalControlOn = false;
    }

    public void toggleParentalControl() {
        isParentalControlOn = !isParentalControlOn;
    }

    public boolean isRelaxAvailableNow() {
        if (!isParentalControlOn)
            return true;
        else return LocalTime.now().getHour() > 15 && LocalTime.now().getHour() < 22;
    }

    public boolean isRelaxAvailable(int hour) {
        if (!isParentalControlOn)
            return true;
        else return hour > 15 && hour < 22;
    }

}
