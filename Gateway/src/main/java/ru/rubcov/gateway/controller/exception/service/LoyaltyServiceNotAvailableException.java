package ru.rubcov.gateway.controller.exception.service;

import org.springframework.http.HttpStatus;
import ru.rubcov.gateway.handler.BaseException;

public class LoyaltyServiceNotAvailableException extends BaseException {
    public static String message = "Loyalty Service unavailable";

    public LoyaltyServiceNotAvailableException(HttpStatus codeStatus) {
        super(message, codeStatus);
    }
}
