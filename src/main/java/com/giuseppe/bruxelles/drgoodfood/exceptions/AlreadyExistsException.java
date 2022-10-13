package com.giuseppe.bruxelles.drgoodfood.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {
    private final String value;
    private final String variable;

    public AlreadyExistsException(String value, String variable) {
        super("A user with " + variable + "'" + value + "' already exists. Please choose another one.");
        this.value = value;
        this.variable = variable;
    }

    public String getValue() {
        return value;
    }
    public String getVariable() {
        return variable;
    }
}