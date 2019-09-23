package com.epam.appliances.exception;

public class CannotTurnOnDueToParentalControlException extends CannotTurnOnDueToUnpluggedlException {

    public CannotTurnOnDueToParentalControlException(String message) {
        super(message);
    }

}
