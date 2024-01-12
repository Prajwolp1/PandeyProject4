
import java.util.Scanner;

public class Customer {
    private String customerName;
    private int customerPin;

    private Scanner scan;

    private Account savingsAccount;
    private Account checkingAccount;

    public Customer(String name, int pin) {
        scan = new Scanner(System.in);
        Account savingsAccount = new Account();
        Account checkingAccount = new Account();
        this.savingsAccount = savingsAccount;
        this.checkingAccount = checkingAccount;
    }


    public void setCustomerPin(int newPin)  {
        customerPin = newPin;
    }


    public void deposit()   {
        System.out.print("Would you like to deposit in your checking or savings account (s/c): ");
        String choice = scan.nextLine();
        System.out.print("How much money would you like to deposit: ");
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
        System.out.print("Would you like to withdraw from your checking or savings account (s/c): ");
        String choice = scan.nextLine();
        System.out.print("How much money would you like to withdraw: ");
        int withDraw = scan.nextInt();
        if (choice.equals("c")) {
                if (withDraw > checkingAccount.getCurrentBalance()) {
                    System.out.println("Insufficient Funds!");
                }
                if (withDraw % 5 != 0) {
                    System.out.println("Invalid Amount! ");
                }
            if (withDraw <= checkingAccount.getCurrentBalance() && withDraw % 5 == 0) {
                int total = withDraw;
                int withDrawAmount = 0;
                System.out.println("How many 20's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 20)) >= 0) {
                    total -= withDrawAmount * 20;
                } else {
                    System.out.println("Cannot retrieve that many 20's");
                }
                System.out.println("How many 10's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 10)) >= 0) {
                    total -= withDrawAmount * 10;
                } else {
                    System.out.println("Cannot retrieve that many 10's");
                }
                System.out.println("How many 5's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 5)) >= 0) {
                    total -= withDrawAmount * 5;
                } else {
                    System.out.println("Cannot retrieve that many 5's");
                }
                System.out.println(total);
                System.out.println("You were given " + total / 5 + " 5's for the remaining amount");
                checkingAccount.loseMoney(withDraw);
            }
        }
        if (choice.equals("s")) {
            if (withDraw > savingsAccount.getCurrentBalance()) {
                System.out.println("Insufficient Funds!");
            }
            if (withDraw % 5 != 0) {
                System.out.println("Invalid Amount! ");
            }
            if (withDraw < savingsAccount.getCurrentBalance() && withDraw % 5 == 0) {
                int total = withDraw;
                int withDrawAmount = 0;
                System.out.print("How many 20's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 20)) > 0) {
                    total -= withDrawAmount;
                } else {
                    System.out.println("Cannot retrieve that many 20's");
                }
                System.out.print("How many 10's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 10)) > 0) {
                    total -= withDrawAmount;
                } else {
                    System.out.println("Cannot retrieve that many 10's");
                }
                System.out.print("How many 5's would you like to withdraw: ");
                withDrawAmount = scan.nextInt();
                if ((total - (withDrawAmount * 5)) > 0) {
                    total -= withDrawAmount;
                } else {
                    System.out.println("Cannot retrieve that many 5's");
                }
                System.out.println("You were given " + total % 5 + " 5's for the remaining amount");
                savingsAccount.loseMoney(withDraw);
            }
        }
    }

    public void transferMoney() {
        System.out.print("What account would you like to transfer money to (s/c): ");
        String transferTo = scan.nextLine();
        System.out.println("You have a balance of " + checkingAccount.getCurrentBalance() + " in your checking account");
        System.out.println("You have a balance of " + savingsAccount.getCurrentBalance() + " in your savings account");

        if (transferTo.equals("s")) {
            System.out.print("How much money will you like to transfer to your savings account from your checking account: ");
            double transfer = scan.nextDouble();
            scan.nextLine();
            while (transfer > checkingAccount.getCurrentBalance())  {
                System.out.println("You do not have that much money in your checking account to transfer! Try Again!");
                System.out.print("How much money will you like to transfer to your savings account from your checking account: ");
                transfer = scan.nextDouble();
                scan.nextLine();
            }
            System.out.println("DONE! \nYou just transferred " + transfer + " from your checking account to your savings account! " );
            checkingAccount.loseMoney(transfer);
            savingsAccount.addMoney(transfer);
        }

        if (transferTo.equals("c")) {
            System.out.print("How much money will you like to transfer to your checking account from your savings account: ");
            double transfer = scan.nextDouble();
            scan.nextLine();
            while (transfer > savingsAccount.getCurrentBalance())  {
                System.out.println("You do not have that much money in your savings account to transfer! Try Again!");
                System.out.print("How much money will you like to transfer to your checking account from your savings account: ");
                transfer = scan.nextDouble();
                scan.nextLine();
            }
            System.out.println("DONE! \nYou just transferred " + transfer + " from your savings account to your checking account! " );
            savingsAccount.loseMoney(transfer);
            checkingAccount.addMoney(transfer);
        }
    }

    public String getBalances() {
        return "Checking Account: " + checkingAccount.getCurrentBalance() + "\nSavings Account: " + savingsAccount.getCurrentBalance();
    }

    public void changePin() {
        System.out.print("What would you like to change your pin to: ");
        int newPin = scan.nextInt();
        setCustomerPin(newPin);
    }


}
