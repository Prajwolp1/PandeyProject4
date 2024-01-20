import java.util.Scanner;
import java.util.WeakHashMap;

public class ATM {

    //creates customer object and creates instance variables
    private Customer customer;
    private String customerName;
    private int customerPin;
    private int end;

    //creates scanner object to get user input
    private Scanner scan;

    //initializes scan and end
    public ATM()    {
        scan = new Scanner(System.in);
        end = 0;
    }

    //sets the customer pin
    public void setCustomerPin(int newPin)  {
        customerPin = newPin;
    }

    //starts the program
    public void start() {
        newCustomer();
    }

    //creates a new customer object
    public void newCustomer() {
        System.out.println("Welcome to the ATM! \nBefore We Start Please Create a New Account \nPlease Enter Name and Create a Pin. \n");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        customerName = name;
        System.out.print("Create a new pin for your account: ");
        customerPin = scan.nextInt();
        ConsoleUtility.clearScreen();
        customer = new Customer();
        System.out.println("Re-enter the pin of your new account!");

        //loop to make sure that the pin is correct
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
        ConsoleUtility.clearScreen();
        mainMenu();
    }

    //prints the main menu
    public void mainMenu()  {
        System.out.print("Welcome to the ATM! ");

        //loops until the end conditions are met
        while (end != 7) {
            System.out.println("\n1. Withdraw Money\n2. Deposit Money\n3. Transfer Money Between Accounts\n4. Get Account Balances\n5. Get Transaction History\n6. Change PIN\n7. Exit");
            int option = 8;
            while (option > 7) {
                System.out.print("Enter a valid number: ");
                option = scan.nextInt();
                scan.nextLine();
                if (option > 7) {
                    System.out.println("Number is not valid try again! ");
                }
            }
            ConsoleUtility.clearScreen();

            //when option one is chosen
            if (option == 1) {
                customer.withDraw();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
                reEnterPin();
            }

            //when option two is chosen
            if (option == 2) {
                customer.deposit();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
                reEnterPin();
            }

            //when option three is chosen
            if (option == 3) {
                customer.transferMoney();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
                reEnterPin();
            }

            //when option four is chosen
            if (option == 4) {
                System.out.println(customer.getBalances());
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
            }

            //when option five is chosen
            if (option == 5) {
                System.out.println(customer.getTransactionHistory());
                System.out.println(customer.getSReceipt("Checked Transaction History!"));
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
                reEnterPin();
            }

            //when option six is chosen
            if (option == 6) {
                changePin();
                System.out.println(customer.getSReceipt("Changed Pin!"));
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
                reEnterPin();
            }
            //when user wants to end the program
            if(option == 7) {
                System.out.println("Thank you for using the ATM and have a great day! ");
            }
        }
    }


    //after user completes an action, they are asked to re-enter the users pin
    public void reEnterPin() {
        System.out.print("Would you like to do anything more (Y/N): ");
        String more = scan.next();

        //if the user wants to do more actions they must re-enter pin
        if (more.equals("Y")) {
            int repeat = 0;
            while (repeat == 0) {
                System.out.print("Re-enter your pin: ");
                int check = scan.nextInt();
                if (check == customerPin) {
                    repeat = 1;
                    mainMenu();
                } else {
                    System.out.println("Invalid Pin");
                }
            }
        }

        //if user wants to end the program
        else {
            System.out.println("Thank you for using the ATM and have a great day! ");
            end = 7;
        }
    }

    //when option six is called and changes pin
    public void changePin() {
        System.out.print("What would you like to change your pin to: ");
        int newPin = scan.nextInt();
        setCustomerPin(newPin);
    }
}


