package com.epam.appliances.controller;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.cooking.CoffeeMachine;
import com.epam.appliances.model.relax.Computer;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GetKitchenApplianceByPowerTest {

    @Test
    public void getKitchenApplianceByPowerTest() {
        SmartHomeController smartHomeController = SmartHomeController.getInstance();

        Appliance coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        Appliance computer = new Computer("Computer", 3000, 6000, Color.GREY);

        List<Appliance> cookingAppliancesByPower = smartHomeController.addAppliance(coffeeMachine)
                .addAppliance(computer)
                .getCookingAppliancesByPower(1300, 1600);

        for (Appliance appliance : cookingAppliancesByPower) {
            assertTrue(appliance.getPower() < 1600 && appliance.getPower() > 1300);
        }
    }

}
