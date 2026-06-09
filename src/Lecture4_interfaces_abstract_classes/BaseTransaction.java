package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Transaction Constructor
     * @param amount the transaction amount
     * @param date: Not null, and must be a Calendar object
     * Instialises the fields of a transaction
     */
    public BaseTransaction(double amount, @NotNull Calendar date)  {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000);
        transactionID = date.toString() + uniq;
    }

    /**
     * getAmount()
     * @return double
     */
    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * getDate()
     * @return Calendar Object
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }

    // Method to get a unique identifier for the transaction
    public String getTransactionID(){
        return  transactionID;
    }

    // Method to print details of the transaction
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: $" + amount);
    }

    // Method to apply the transaction on a bank account
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba == null) {
            throw new IllegalArgumentException("BankAccount cannot be null.");
        }
        System.out.println("BaseTransaction: No balance changes applied. Current balance verified: $" + ba.getBalance());
    }
}
