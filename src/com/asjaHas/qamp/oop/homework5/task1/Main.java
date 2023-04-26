package com.asjaHas.qamp.oop.homework5.task1;

public class Main {
    public static void main(String[] args) {
        final Owner owner1 = new Owner("John", "Doe", "Some address 01");
        final Owner owner2 = new Owner("Jane", "Doe", "Some address 02");

        try {
            final Account account1 = new CurrentAccount(owner1, "123456789", 1111, 10000);
            final Account account2 = new SavingsAccount(owner2, "987654321", 9999, 1000);
            AccountRegister accountRegister = new AccountRegister();
            accountRegister.addAccount(account1);
            accountRegister.addAccount(account2);

            final ATM atm = new ATM(accountRegister);

            System.out.println("Original account state: ");
            System.out.println(atm.showAccountState("123456789", 1111));
            atm.withdraw(1000, "123456789", 1111);
            atm.withdraw(1000, "123456789", 1111);
            atm.withdraw(1000, "123456789", 1111);
            atm.withdraw(8000, "123456789", 1111);
            atm.deposit(500, "123456789", 1111);
            System.out.println("\nAccount state after 4 withdrawals and 1 deposit: ");
            System.out.println(atm.showAccountState("123456789", 1111));

            System.out.println("\nOriginal account state: ");
            System.out.println(atm.showAccountState("987654321", 9999));
            atm.withdraw(250, "987654321", 9999);
            atm.withdraw(250, "987654321", 9999);
            System.out.println("\nAccount state after 2 withdrawals: ");
            System.out.println(atm.showAccountState("987654321", 9999));

            atm.reset("987654321", 9999);
            System.out.println("\nAccount state after reset: ");
            System.out.println(atm.showAccountState("987654321", 9999));

//      Try to withdraw with wrong serial number
            atm.withdraw(1000, "997654321", 9999);

//      Try to withdraw with wrong password
            atm.withdraw(1000, "987654321", 2222);

//      Try to withdraw with wrong password
            atm.withdraw(1000, "987654321", 999);

//      Try to withdraw over current balance
            atm.withdraw(1000, "987654321", 9999);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}

