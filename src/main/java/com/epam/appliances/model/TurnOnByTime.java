package com.epam.appliances.model;

import com.epam.appliances.exception.CannotTurnOnDueToParentalControlException;

public interface TurnOnByTime {

    void setTheTimer(int hour) throws CannotTurnOnDueToParentalControlException;

}
