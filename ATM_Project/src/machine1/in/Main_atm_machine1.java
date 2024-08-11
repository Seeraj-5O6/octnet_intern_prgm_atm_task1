package machine1.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import machine2.in.Atm_machine2;



public class Main_atm_machine1 {

	public static void main(String[] args) {
		
		
		  Scanner scanner = new Scanner(System.in);
	        Atm_machine2 atm = new Atm_machine2(100000.00, 6677);
	        int option = 0;
	        double amount;
	        int inputPin;
	        boolean authenticated = false;
	        int pinAttempts = 0;
	        
	        // User authentication loop with limited attempts
	        while (!authenticated && pinAttempts < 3) {
	            try {
	                System.out.print("Enter your PIN: ");
	                inputPin = scanner.nextInt();
	                pinAttempts++;

	                if (atm.authenticate(inputPin)) {
	                    authenticated = true;
	                    System.out.println("Authentication successful!");
	                } else {
	                    System.out.println("Incorrect PIN. Please try again.");
	                    if (pinAttempts >= 3) {
	                        System.out.println("ALERT! Money Stolen! The robber has attempted to access your account.");
	                    }
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a valid PIN.");
	                scanner.next(); // clear the invalid input
	            }
	        }

	        // Exit if the user failed authentication
	        if (!authenticated) {
	            System.out.println("Exiting the system for security reasons.");
	            scanner.close();
	            return;
	        }

	        // Main menu loop
	        do {
	            try {
	                System.out.println("\nATM Menu:");
	                System.out.println("1. Check Balance");
	                System.out.println("2. Deposit Cash");
	                System.out.println("3. Withdraw Cash");
	                System.out.println("4. Change PIN");
	                System.out.println("5. View Transaction History");
	                System.out.println("6. Exit");
	                System.out.print("Choose an option: ");
	                option = scanner.nextInt();

	                switch (option) {
	                    case 1:
	                        atm.checkBalance();
	                        break;
	                    case 2:
	                        System.out.print("Enter deposit amount: ");
	                        amount = scanner.nextDouble();
	                        atm.deposit(amount);
	                        break;
	                    case 3:
	                        System.out.print("Enter withdrawal amount: ");
	                        amount = scanner.nextDouble();
	                        atm.withdraw(amount);
	                        break;
	                    case 4:
	                        System.out.print("Enter new PIN: ");
	                        inputPin = scanner.nextInt();
	                        atm.changePin(inputPin);
	                        break;
	                    case 5:
	                        atm.displayTransactionHistory();
	                        break;
	                    case 6:
	                        System.out.println("Thank you for using the ATM. Goodbye!");
	                        break;
	                    default:
	                        System.out.println("Invalid option. Please choose again.");
	                        break;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next(); // clear the invalid input
	            }
	        } while (option != 6);

	        scanner.close();
	}

}
