
import java.util.Scanner;




public class Customer {
    private String customerName;
    private int customerPin;

    private Account savingsAccount;
    private Account checkingAccount;

    public Customer() {
        Account savingsAccount = new Account();
        Account checkingAccount = new Account();
        this.savingsAccount = savingsAccount;
        this.checkingAccount = checkingAccount;
    }


    public void setCustomerPin(int newPin)  {
        customerPin = newPin;
    }


    public void newCustomer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the ATM! \nBefore We Start Please Create a New Account \nPlease Enter Name and Create a Pin. \n");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        customerName = name;
        System.out.print("Create a new pin for your account: ");
        int pin = scan.nextInt();
        customerPin = pin;
        ATM info = new ATM();
        info.mainMenu(customerName, customerPin);
    }

    public void deposit()   {
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to deposit in your checkings or savings account (s/c): ");
        String choice = scan.nextLine();
        System.out.println("How much money would you like to deposit: ");
        double deposit = scan.nextDouble();
        scan.nextLine();
        if (choice.equals("c"))   {
            checkingAccount.addMoney(deposit);
        }
        if (choice.equals("s"))   {
            savingsAccount.addMoney(deposit);
        }
    }

    public void withDraw()  {
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to deposit in your checkings or savings account (s/c): ");
        String choice = scan.nextLine();
        int withDraw = 0;
        if (choice.equals("c")) {
            while (withDraw > checkingAccount.getCurrentBalance() && (withDraw % 5 != 0)) {
                System.out.println("How much money would you like to withdraw: ");
                withDraw = scan.nextInt();
                scan.nextLine();
                if (withDraw > checkingAccount.getCurrentBalance()) {
                    System.out.println("Insufficient Funds!");
                }
                if (withDraw % 5 != 0)  {
                    System.out.println("Invalid Amount! ");
                }
            }
            int total = withDraw;
            int withDrawAmount = 0;
            System.out.println("How many 20's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 20)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 20's");
            }
            System.out.println("How many 10's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 10)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 10's");
            }
            System.out.println("How many 5's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 5)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 5's");
            }
            System.out.println("You were given " + total % 5 + " 5's for the remaining amount");
            checkingAccount.loseMoney(withDraw);
        }
        if (choice.equals("s")) {
            while (withDraw > savingsAccount.getCurrentBalance() && (withDraw % 5 != 0)) {
                System.out.println("How much money would you like to withdraw: ");
                withDraw = scan.nextInt();
                scan.nextLine();
                if (withDraw > savingsAccount.getCurrentBalance()) {
                    System.out.println("Insufficient Funds!");
                }
                if (withDraw % 5 != 0)  {
                    System.out.println("Invalid Amount! ");
                }
            }
            int total = withDraw;
            int withDrawAmount = 0;
            System.out.println("How many 20's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 20)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 20's");
            }
            System.out.println("How many 10's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 10)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 10's");
            }
            System.out.println("How many 5's would you like to withdraw: ");
            withDrawAmount = scan.nextInt();
            if ((total - (withDrawAmount * 5)) > 0) {
                total -= withDrawAmount;
            }   else {
                System.out.println("Cannot retrieve that many 5's");
            }
            System.out.println("You were given " + total % 5 + " 5's for the remaining amount");
            savingsAccount.loseMoney(withDraw);
        }
    }

    public void transferMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What account would you to transfer money to (s/c): ");
        String transferTo = scan.nextLine();
        System.out.println("You have a balance of " + checkingAccount + " in your checkings account");
        System.out.println("You have a balance of " + savingsAccount + " in your savings account");
        System.out.println("How much money will you like to transfer: ");
        double transfer = scan.nextDouble();
        scan.nextLine();
        if (transferTo.equals("s")) {

        }
    }
}
