package com.ecommerce.exception;

public class CustomException extends RuntimeException {

    private int statusCode;
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
