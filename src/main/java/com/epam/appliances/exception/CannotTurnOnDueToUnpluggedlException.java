package com.epam.appliances.exception;

@SuppressWarnings("serial") // Task 1
public class CannotTurnOnDueToUnpluggedlException extends Exception {

    public CannotTurnOnDueToUnpluggedlException(String message) {
        super(message);
    }

}
