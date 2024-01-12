import java.util.Scanner;
import java.util.WeakHashMap;

public class ATM {
    private String customerName;
    private int customerPin;
    public ATM()    {

    }
    public void start() {
        newCustomer();
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
        mainMenu();
    }


    public void mainMenu()  {
        Customer customer = new Customer(customerName, customerPin);
        Scanner scan = new Scanner(System.in);
        System.out.println("Re-enter the details of your new account!");
        String givenName = "";
        while (!(givenName.equals(customerName)))  {
            System.out.print("Enter your name: ");
            givenName = scan.nextLine();
            if (!(givenName.equals(customerName)))  {
                System.out.println("\nCannot find name in the database. Try Again");
            }
        }
        int repeat = -1;
        while (repeat == -1)    {
            System.out.print("Enter your pin: ");
            int pin = scan.nextInt();
            if (pin == customerPin)   {
                repeat = 0;
            } else {
                System.out.print("Wrong pin. Please try again. ");
                System.out.println(" ");
            }
        }
        System.out.println("");
        System.out.print("Welcome to the ATM! ");
        int end = 7;
        while (end == 7) {
            System.out.println("Menu \n1. Withdraw Money\n2. Deposit Money\n3. Transfer Money Between Accounts\n4. Get Account Balances\n5. Get Transaction History\n6. Change PIN\n7. Exit");

            int option = 9;
            while (option > 7) {
                System.out.print("Enter a valid number: ");
                option = scan.nextInt();
                scan.nextLine();
                if (option > 7) {
                    System.out.println("Number is not valid try again! ");
                }
            }
            if (option == 1) {
                customer.withDraw();
            }

            if (option == 2) {
                customer.deposit();
            }

            if (option == 3) {
                customer.transferMoney();
            }

            if (option == 4) {
                System.out.println(customer.getBalances());
            }

            if (option == 5) {

            }

            if (option == 6) {
                customer.changePin();
            }

            if(option == 7) {
                System.out.println("Thank you for using the ATM and have a great day! ");
            }

        }

    }
}


