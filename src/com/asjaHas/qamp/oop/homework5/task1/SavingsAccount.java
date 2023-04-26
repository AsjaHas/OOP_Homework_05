package com.asjaHas.qamp.oop.homework5.task1;

public class SavingsAccount extends Account {
    private double transactionLimit;
    private final double definedTransactionLimit;
    private int transactionsLeft;
    private double totalWithdrawn;

    public SavingsAccount(final Owner owner, final String serialNumber, final int passcode, final double balance, final double definedTransactionLimit) {
        super(owner, serialNumber, passcode, balance);
        this.transactionLimit = definedTransactionLimit;
        this.definedTransactionLimit = definedTransactionLimit;
        this.transactionsLeft = 3;
        this.totalWithdrawn = 0;
    }

    public SavingsAccount(final Owner owner, final String serialNumber, final int passcode, final double balance) {
        super(owner, serialNumber, passcode, balance);
        this.transactionLimit = 1000;
        this.definedTransactionLimit = 1000;
        this.transactionsLeft = 3;
        this.totalWithdrawn = 0;
    }

    private void validateTransaction(final double newBalance, final int transactionsLeft, final double totalWithdrawn) throws IllegalStateException {
        if (transactionsLeft < 0) {
            throw new IllegalStateException("Daily number of transactions exceeded.");
        }
        if (totalWithdrawn > definedTransactionLimit) {
            throw new IllegalStateException("Daily transaction limit exceeded.");
        }
        if (newBalance < 0) {
            throw new IllegalStateException("Not enough funds.");
        }
    }

    @Override
    public double withdraw(final double amount) {
        double newBalance = getBalance() - amount;
        validateTransaction(newBalance, transactionsLeft - 1, totalWithdrawn - amount);
        transactionsLeft--;
        transactionLimit -= amount;
        totalWithdrawn += amount;
        setBalance(newBalance);
        return amount;
    }

    @Override
    public double deposit(final double amount) {
        double newBalance = getBalance() + amount;
        validateTransaction(newBalance, transactionsLeft - 1, totalWithdrawn);
        transactionsLeft--;
        setBalance(newBalance);
        return amount;
    }

    @Override
    public void reset() {
        this.transactionLimit = this.definedTransactionLimit;
        this.transactionsLeft = 3;
    }

    @Override
    public String showAccountState() {
        return getOwner().toString() + "\nCurrent balance: " + getBalance() + "\nCurrent daily limit: " + transactionLimit + "\nNumber of available transactions: " + transactionsLeft;
    }
}
