package com.epam.appliances;

import com.epam.appliances.annotations.ThisCodeSmells;
import com.epam.appliances.controller.SmartHomeController;
import com.epam.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.appliances.exception.CannotTurnOnDueToUnpluggedlException;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.TurnOnByTime;
import com.epam.appliances.model.cooking.CoffeeMachine;
import com.epam.appliances.model.cooking.Kettle;
import com.epam.appliances.model.relax.Computer;
import com.epam.appliances.model.relax.RelaxAppliance;
import com.epam.appliances.model.relax.TV;
import com.epam.appliances.util.AnnotationHandler;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.epam.appliances.util.AnnotationHandler.getClasses;

@ThisCodeSmells
@ThisCodeSmells(reviewer = "Vanya")
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SmartHomeController smartHomeController = SmartHomeController.getInstance();

        CoffeeMachine coffeeMachine = null;
        try { // Task 2.1
            Class<?> clazz = Class.forName("com.epam.appliances.model.cooking.CoffeeMachine");
            Constructor constructor = clazz.getConstructor(String.class, int.class, int.class, Color.class);
            coffeeMachine = (CoffeeMachine) constructor.newInstance("Coffee machine", 1500, 1600, Color.BLACK);
            coffeeMachine = coffeeMachine.addMilk();
            coffeeMachine.plug();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Kettle kettle = new Kettle("Kettle", 1100, 900, Color.BROWN).addHoney();

        Computer computer = null;
        try { // Task 2.1
            Class<?> clazz = Class.forName("com.epam.appliances.model.relax.Computer");
            Constructor constructor = clazz.getConstructor(String.class, int.class, int.class, Color.class);
            computer = (Computer) constructor.newInstance("Coffee machine", 1500, 1600, Color.BLACK);
            computer = computer.setScreenSize(19)
                    .setRam(16)
                    .setCpu(2.5);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        computer.plug();

        RelaxAppliance tv = new TV("TV", 4000, 7000, Color.WHITE);
        try { // Task 2.2
            Field screenSize = tv.getClass().getDeclaredField("screenSize");
            screenSize.setAccessible(true);
            screenSize.set(tv, 30);
            Field isFourK = tv.getClass().getDeclaredField("isFourK");
            isFourK.setAccessible(true);
            isFourK.set(tv, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        tv.plug();

        smartHomeController.addAppliance(coffeeMachine)
                .addAppliance(computer)
                .addAppliance(kettle)
                .addAppliance(tv);

        try { // Task 2.3
            Method getCurrentTotalPowerConsumption = SmartHomeController.class.getDeclaredMethod(
                    "getCurrentTotalPowerConsumption");
            System.out.println("Current total power consumption - " + getCurrentTotalPowerConsumption.invoke(smartHomeController));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

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

        TurnOnByTime turnOnByTime = (relaxAppliance, hour) -> {
            if (relaxAppliance.isRelaxAvailable(hour))
                relaxAppliance.setTimer(hour);
            else
                throw new CannotTurnOnDueToParentalControlException("Cannot set up the timer on TV due to parental control");
        };

        try {
            computer.setTheTimer(23, turnOnByTime);
            computer.turnOn();
        } catch (CannotTurnOnDueToParentalControlException e) {
            System.out.println(e.getMessage());
        } catch (CannotTurnOnDueToUnpluggedlException e) {
            System.out.println(e.getMessage());
        }

        // Task 2.4
        AnnotationHandler.printAllSmellingCode();
        getClasses("com.epam.appliances")
                .stream()
                .filter(c -> c.isAnnotationPresent(ThisCodeSmells.class))
                .forEach(AnnotationHandler::printClassMetadata);
    }

}
