package com.epam.appliances.service;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.garden.LawnMower;
import com.epam.appliances.model.kitchen.CoffeeMachine;
import com.epam.appliances.model.working.Computer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TotalPowerConsumptionTest {

    @Test
    public void rentACheapestFlatTest() {
        Landlord landlord = new Landlord("Bill", "Erickson", 400);

        Appliance coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        coffeeMachine.plug();
        Appliance lawnMower = new LawnMower("Lawn Mower", 5000, 11000, Color.BLUE);
        lawnMower.plug();
        Appliance computer = new Computer("Computer", 3000, 6000, Color.GREY);

        int totalPowerConsumption = landlord.buyAppliance(coffeeMachine)
                .buyAppliance(lawnMower)
                .buyAppliance(computer)
                .getTotalPowerConsumption();

        assertEquals(totalPowerConsumption, 6500);
    }

}
