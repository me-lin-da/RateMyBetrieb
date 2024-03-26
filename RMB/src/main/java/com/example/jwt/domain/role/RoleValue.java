package com.example.jwt.domain.role;

public enum RoleValue {
    // This will call enum constructor with one
    // String argument
    ADMIN("ADMIN"), USER("USER");

    // declaring private variable for getting values
    private final String value;

    // enum constructor - cannot be public or protected
    RoleValue(String value) {
        this.value = value;
    }

    // getter method
    public String getValue() {
        return this.value;
    }
}
