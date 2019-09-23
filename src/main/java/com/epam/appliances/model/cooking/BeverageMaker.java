package com.epam.appliances.model.cooking;

import com.epam.appliances.exception.NotEnoughWaterException;
import com.epam.appliances.exception.TheBeverageMakerIsFullException;
import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.AppliancePurpose;
import com.epam.appliances.model.Color;

public abstract class BeverageMaker extends Appliance {

    protected int maxCountOfBeverages = 3;
    protected int availableBeverages;

    public int getAvailableBeverages() {
        return availableBeverages;
    }

    public BeverageMaker(String title, AppliancePurpose appliancePurpose, int power, int weight, Color color) {
        super(title, appliancePurpose, power, weight, color);
        availableBeverages = maxCountOfBeverages;
    }

    public void makeBeverage() {
        if (availableBeverages == 0) {
            throw new NotEnoughWaterException("Not enough water for making beverage, add water please");
        } else availableBeverages--;
    }

    public void addWater() {
        if (availableBeverages == maxCountOfBeverages) {
            throw new TheBeverageMakerIsFullException("The Beverage Maker is full, it doesn't need any water");
        } else availableBeverages = maxCountOfBeverages;
    }


}
