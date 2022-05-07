package com.kbe.warehouse.message;

public class ResponseMessage {

    private String message;

    private ResponseMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
