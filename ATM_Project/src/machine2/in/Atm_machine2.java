package machine2.in;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Atm_machine2 {
	
	private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;
    
    
    public Atm_machine2(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
        
    }

    

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You have successfully deposited: $" + amount);
            transactionHistory.add("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You have successfully withdrawn: $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void changePin(int newPin) {
        if (newPin >= 1000 && newPin <= 9999) {
            this.pin = newPin;
            System.out.println("Your PIN has been successfully changed.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("Invalid PIN. Please enter a 4-digit number.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public boolean authenticate(int inputPin) {
        return this.pin == inputPin;
    }
    
    
    
    
}
