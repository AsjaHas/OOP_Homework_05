package com.asjaHas.qamp.oop.homework5.task1;

public class ATM {
    private final AccountRegister accountRegister;

    public ATM(AccountRegister accountRegister) {
        this.accountRegister = accountRegister;
    }


    public double withdraw(final double amount, final String serialNum, final int passcode) {
        return accountRegister.withdraw(amount, serialNum, passcode);
    }

    public double deposit(final double amount, final String serialNum, final int passcode) {
        return accountRegister.deposit(amount, serialNum, passcode);
    }

    public void reset(final String serialNum, final int passcode) {
        accountRegister.reset(serialNum, passcode);
    }

    public String showAccountState(final String serialNum, final int passcode) {
        return accountRegister.showAccountState(serialNum, passcode);
    }

}
