package com.mindia.carmind.utils.exception.custom;

import java.util.Map;

import com.mindia.carmind.utils.Convertions;

public class UserHubException extends RuntimeException{
    
    private int code;
    private String error, message;


    public UserHubException(String body) {
        Map<String, Object> map = Convertions.fromJson(body);
        this.code = (int) map.get("code");
        this.error = (String) map.get("error");
        this.message = (String) map.get("message");
    }


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
