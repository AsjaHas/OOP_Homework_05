package com.asjaHas.qamp.oop.homework5.task1;

public abstract class Account implements Withdraw, Deposit {
    private final Owner owner;
    private final String serialNum;
    private final int passcode;
    private double balance;

    public Account(Owner owner, String serialNum, int passcode, double balance) {
        this.owner = owner;
        this.serialNum = serialNum;
        this.passcode = passcode;
        this.balance = balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public void validPasscode(final int passcode) {
        if (1000 > passcode && passcode > 9999) {
            throw new IllegalArgumentException("Provided passcode is outside of legal range of numbers (1000-9999)");
        }
    }

    public void correctPasscode(final int passcode) {
        if (this.passcode != passcode) {
            throw new IllegalStateException("Provided passcode is not correct");
        }
    }

    public abstract double withdraw(final double amount);

    public abstract double deposit(final double amount);

    public abstract void reset();

    public abstract String showAccountState();
}
