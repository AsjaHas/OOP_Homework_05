package com.asjaHas.qamp.oop.homework5.task1;

public class CurrentAccount extends Account {

    public CurrentAccount(final Owner owner, final String serialNumber, final int passcode, final double balance) {
        super(owner, serialNumber, passcode, balance);
    }

    @Override
    public double withdraw(final double amount) {
        setBalance(getBalance() - amount);
        return amount;
    }

    @Override
    public double deposit(final double amount) {
        setBalance(getBalance() + amount);
        return amount;
    }

    @Override
    public void reset() {
        // does nothing
    }

    @Override
    public String showAccountState() {
        return getOwner().toString() + "\nCurrent balance: " + getBalance();
    }
}
