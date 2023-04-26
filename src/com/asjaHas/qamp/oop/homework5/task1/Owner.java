package com.asjaHas.qamp.oop.homework5.task1;

public class Owner {
    private final String firstName;
    private final String lastName;
    private final String address;

    public Owner(final String firstName, final String lastName, final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String toString() {
        return "Owner: " + firstName + ", " + lastName + ", " + address;
    }
}
