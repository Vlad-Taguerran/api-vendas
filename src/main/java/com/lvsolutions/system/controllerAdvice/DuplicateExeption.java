package com.lvsolutions.system.controllerAdvice;

public class DuplicateExeption extends RuntimeException {
    public DuplicateExeption(String message) {
        super(message);
    }
}
