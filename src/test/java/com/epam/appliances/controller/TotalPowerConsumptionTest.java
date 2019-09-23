package com.epam.appliances.controller;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.cooking.CoffeeMachine;
import com.epam.appliances.model.relax.Computer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TotalPowerConsumptionTest {

    @Test
    public void rentACheapestFlatTest() {
        SmartHomeController smartHomeController = SmartHomeController.getInstance();

        Appliance coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        coffeeMachine.plug();
        Appliance computer = new Computer("Computer", 3000, 6000, Color.GREY);

        int totalPowerConsumption = smartHomeController.addAppliance(coffeeMachine)
                .addAppliance(computer)
                .getCurrentTotalPowerConsumption();

        assertEquals(totalPowerConsumption, 1500);
    }

}
