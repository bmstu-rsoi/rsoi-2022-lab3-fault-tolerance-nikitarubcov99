package ru.rubcov.gateway.controller.exception.service;

import org.springframework.http.HttpStatus;
import ru.rubcov.gateway.handler.BaseException;

public class PaymentServiceNotAvailableException extends BaseException {
    public static String message = "Payment Service unavailable";

    public PaymentServiceNotAvailableException(HttpStatus codeStatus) {
        super(message, codeStatus);
    }
}