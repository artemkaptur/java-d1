package com.epam.appliances.exception;

public final class NotEnoughMoneyException extends RuntimeException {

    private static final long serialVersionUID = 3533193618822689359L;

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
