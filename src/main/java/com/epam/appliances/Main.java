package com.epam.appliances;

import com.epam.appliances.controller.SmartHomeController;
import com.epam.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.appliances.exception.CannotTurnOnDueToUnpluggedlException;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.cooking.BeverageMaker;
import com.epam.appliances.model.cooking.CoffeeMachine;
import com.epam.appliances.model.cooking.Kettle;
import com.epam.appliances.model.relax.Computer;
import com.epam.appliances.model.relax.RelaxAppliance;
import com.epam.appliances.model.relax.TV;

public class Main {

    public static void main(String[] args) {

        SmartHomeController smartHomeController = SmartHomeController.getInstance();
        BeverageMaker coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 1600, Color.BLACK).addMilk();
        Kettle kettle = new Kettle("Kettle", 1100, 900, Color.BROWN).addHoney();
        coffeeMachine.plug();

        Computer computer = new Computer("Computer", 3000, 6000, Color.GREY)
                .setScreenSize(19)
                .setRam(16)
                .setCpu(2.5);
        RelaxAppliance tv = new TV("TV", 4000, 7000, Color.WHITE)
                .setScreenSize(30)
                .setFourK(true);
        tv.plug();

        smartHomeController.addAppliance(coffeeMachine)
                .addAppliance(computer)
                .addAppliance(kettle)
                .addAppliance(tv);

        System.out.println("Current total power consumption - " + smartHomeController.getCurrentTotalPowerConsumption());

        System.out.println("Before sorted:\n");
        smartHomeController.showAllAppliances();
        System.out.println("After sorted:\n");
        smartHomeController.sortByApplianceType();
        smartHomeController.showAllAppliances();

        System.out.println("Cooking appliance with power > 1300 and < 1600 - "
                + smartHomeController.getCookingAppliancesByPower(1300, 1600).toString());

        kettle.makeBeverage();
        kettle.makeBeverage();
        System.out.println(String.format("There is only %s available beverage", kettle.getAvailableBeverages()));

        computer.toggleParentalControl();
        try {
            computer.setTheTimer(23);
            computer.turnOn();
        } catch (CannotTurnOnDueToParentalControlException e) {
            System.out.println(e.getMessage());
        } catch (CannotTurnOnDueToUnpluggedlException e) {
            System.out.println(e.getMessage());
        }
    }

}
