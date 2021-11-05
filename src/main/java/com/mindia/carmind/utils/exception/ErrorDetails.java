package com.mindia.carmind.utils.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String errorCode;

    public ErrorDetails() {
        this.timestamp = new Date();
    }

    public ErrorDetails(String message, String error) {
        this.timestamp = new Date();
        this.message = message;
        this.errorCode = error;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return this.errorCode;
    }

    public void setError(String error) {
        this.errorCode = error;
    }


}
