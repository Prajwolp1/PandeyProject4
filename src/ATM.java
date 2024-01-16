import java.util.Scanner;
import java.util.WeakHashMap;

public class ATM {
    private Customer customer;
    private String customerName;
    private int customerPin;
    private int end;
    private Scanner scan;
    public ATM()    {
        scan = new Scanner(System.in);
        end = 0;
    }
    public void start() {
        newCustomer();
    }

    public void setCustomerPin(int newPin)  {
        customerPin = newPin;
    }

    public void newCustomer() {
        System.out.println("Welcome to the ATM! \nBefore We Start Please Create a New Account \nPlease Enter Name and Create a Pin. \n");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        customerName = name;
        System.out.print("Create a new pin for your account: ");
        customerPin = scan.nextInt();
        customer = new Customer(customerName, customerPin);
        System.out.println("Re-enter the pin of your new account!");
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
        mainMenu();
    }


    public void mainMenu()  {
        System.out.println("");
        System.out.print("Welcome to the ATM! ");
        while (end != 7) {
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
                reEnterPin();
            }

            if (option == 2) {
                customer.deposit();
                reEnterPin();
            }

            if (option == 3) {
                customer.transferMoney();
                reEnterPin();
            }

            if (option == 4) {
                System.out.println(customer.getBalances());
            }

            if (option == 5) {

                reEnterPin();
            }

            if (option == 6) {
                changePin();
                reEnterPin();
            }

            if(option == 7) {
                System.out.println("Thank you for using the ATM and have a great day! ");
            }
        }
    }



    public void reEnterPin() {
        System.out.print("Would you like to do anything more (Y/N): ");
        String more = scan.next();
        if (more.equals("Y")) {
            System.out.print("Re-enter your pin: ");
            int check = scan.nextInt();
            if (check == customerPin) {
                mainMenu();
            }
            else {
                System.out.println("Invalid Pin");
                end = 7;
            }
        }   else {
            end = 7;
        }
    }

    public void changePin() {
        System.out.print("What would you like to change your pin to: ");
        int newPin = scan.nextInt();
        setCustomerPin(newPin);
    }
}


