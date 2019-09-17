package com.epam.appliances;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.garden.LawnMower;
import com.epam.appliances.model.kitchen.CoffeeMachine;
import com.epam.appliances.model.working.Computer;
import com.epam.appliances.service.Landlord;
import com.epam.appliances.service.Tenant;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Tenant tenant = new Tenant("John", "Smith", 500);

        Landlord landlord = new Landlord("Bill", "Erickson", 400);
        Landlord landlord2 = new Landlord("Kyle", "Erickson", 300);
        Set<Landlord> landlords = new HashSet<>();
        landlords.add(landlord);
        landlords.add(landlord2);

        Landlord tenantsLandlord = tenant.rentACheapestFlat(landlords);

        Appliance coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 900, Color.BLACK);
        coffeeMachine.plug();
        Appliance lawnMower = new LawnMower("Lawn Mower", 5000, 11000, Color.BLUE);
        lawnMower.plug();
        Appliance computer = new Computer("Computer", 3000, 6000, Color.GREY);

        tenantsLandlord = landlord.buyAppliance(coffeeMachine)
                .buyAppliance(lawnMower)
                .buyAppliance(computer);

        System.out.println("Before sorted:\n");
        tenantsLandlord.showAllAppliances();
        System.out.println("After sorted:\n");
        tenantsLandlord.sortByApplianceType();
        tenantsLandlord.showAllAppliances();
    }

}
