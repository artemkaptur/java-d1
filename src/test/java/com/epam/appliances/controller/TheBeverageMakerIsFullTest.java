package com.epam.appliances.controller;

import com.epam.appliances.exception.TheBeverageMakerIsFullException;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.cooking.CoffeeMachine;
import org.testng.annotations.Test;

public class TheBeverageMakerIsFullTest {

    @Test(expectedExceptions = TheBeverageMakerIsFullException.class)
    public void notEnoughWaterTest() {
        CoffeeMachine coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        coffeeMachine.addWater();
    }

}
