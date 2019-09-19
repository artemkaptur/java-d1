package com.epam.appliances.controller;

import com.epam.appliances.exception.NotEnoughWaterException;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.cooking.CoffeeMachine;
import org.testng.annotations.Test;

public class NotEnoughWaterTest {

    @Test(expectedExceptions = NotEnoughWaterException.class)
    public void notEnoughWaterTest() {
        CoffeeMachine coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLUE);
        coffeeMachine.makeBeverage();
        coffeeMachine.makeBeverage();
        coffeeMachine.makeBeverage();
        coffeeMachine.makeBeverage();
    }

}
