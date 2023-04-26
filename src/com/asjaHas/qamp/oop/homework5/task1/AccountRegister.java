package com.asjaHas.qamp.oop.homework5.task1;

import java.util.ArrayList;

public class AccountRegister {
    private final ArrayList<Account> accountRegister;

    public AccountRegister() {
        this.accountRegister = new ArrayList<>();
    }

    public void addAccount(final Account account) {
        this.accountRegister.add(account);
    }

    private Account findAccount(final String serialNum, final int passcode) {
        for (Account account : accountRegister) {
            if (account.getSerialNum().equals(serialNum)) {
                account.validPasscode(passcode);
                account.correctPasscode(passcode);
                return account;
            }
        }
        throw new IllegalStateException("Account with serial number " + serialNum + " not found.");
    }

    public double withdraw(final double amount, final String serialNum, final int passcode) {
        return findAccount(serialNum, passcode).withdraw(amount);
    }

    public double deposit(final double amount, final String serialNum, final int passcode) {
        return findAccount(serialNum, passcode).deposit(amount);
    }

    public void reset(final String serialNum, final int passcode) {
        findAccount(serialNum, passcode).reset();
    }

    public String showAccountState(final String serialNum, final int passcode) {
        return findAccount(serialNum, passcode).showAccountState();
    }
}
