package ru.rubcov.gateway.controller.exception.service;

import org.springframework.http.HttpStatus;
import ru.rubcov.gateway.handler.BaseException;


public class HotelServiceNotAvailableException extends BaseException {
    public static String message = "Hotel Service unavailable";

    public HotelServiceNotAvailableException(HttpStatus codeStatus) {
        super(message, codeStatus);
    }
}
