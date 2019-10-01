package com.epam.appliances.model;

import com.epam.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.appliances.model.relax.RelaxAppliance;

@FunctionalInterface // Task 1
public interface TurnOnByTime {

    void setTheTimer(RelaxAppliance appliance, int hour) throws CannotTurnOnDueToParentalControlException;

}
