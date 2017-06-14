package com.si.exception;

public class IdFormatException extends java.lang.Exception {
    public IdFormatException(String id) {
        super("Incorrect id: " + id);
    }
}
