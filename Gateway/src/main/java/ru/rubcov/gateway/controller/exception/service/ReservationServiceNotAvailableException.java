package ru.rubcov.gateway.controller.exception.service;

import org.springframework.http.HttpStatus;
import ru.rubcov.gateway.handler.BaseException;

public class ReservationServiceNotAvailableException extends BaseException {
    public static String message = "Hotel Service unavailable";

    public ReservationServiceNotAvailableException(HttpStatus codeStatus) {
        super(message, codeStatus);
    }
}
