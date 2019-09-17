package com.epam.appliances.service;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.kitchen.CoffeeMachine;
import com.epam.appliances.model.kitchen.Oven;
import com.epam.appliances.model.working.Computer;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GetKitchenApplianceByPowerTest {

    @Test
    public void getKitchenApplianceByPowerTest() {
        Landlord landlord = new Landlord("Bill", "Erickson", 400);

        Appliance coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        Appliance lawnMower = new Oven("Oven", 3500, 8000, Color.BROWN);
        Appliance computer = new Computer("Computer", 3000, 6000, Color.GREY);

        List<Appliance> kitchenAppliancesByPower = landlord.buyAppliance(coffeeMachine)
                .buyAppliance(lawnMower)
                .buyAppliance(computer)
                .getKitchenApplianceByPower(1300, 1600);

        for (Appliance appliance : kitchenAppliancesByPower) {
            assertTrue(appliance.getPower() < 1600 && appliance.getPower() > 1300);
        }
    }

}
