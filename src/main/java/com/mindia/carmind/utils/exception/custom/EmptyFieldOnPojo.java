package com.mindia.carmind.utils.exception.custom;

public class EmptyFieldOnPojo extends RuntimeException{
    
    private String nameField;
    private String message;


    public EmptyFieldOnPojo(String nameField) {
        this.nameField = nameField;
        this.message = "EL valor "+ nameField + " esta vacio.";
    }

    public String getNameField() {
        return this.nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
