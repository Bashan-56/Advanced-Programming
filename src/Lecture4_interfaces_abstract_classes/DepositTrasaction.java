package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(double amount, @NotNull Calendar date){
        super(amount, date);
    }

    private boolean checkDepositAmount(double amt){
        return amt >= 0;
    }

    // Method to print a transaction receipt or details
    @Override
    public void printTransactionDetails(){
        System.out.println("--- Deposit Transaction Receipt ---");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Amount: $" + getAmount());
        System.out.println("Type: Deposit (Irreversible)");
        System.out.println("-----------------------------------");
    }

    @Override
    public void apply(BankAccount ba){
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount cannot be null.");
        }
        if (!checkDepositAmount(getAmount())) {
            System.out.println("Error: Deposit amount cannot be negative.");
            return;
        }
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
        System.out.println("Deposit applied: Credited $" + getAmount() + ". New Balance: $" + new_balance);
    }
}
