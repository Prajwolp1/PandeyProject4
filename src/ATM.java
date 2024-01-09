import java.util.Scanner;
import java.util.WeakHashMap;

public class ATM {
    private Customer customer;
    public ATM()    {

    }
    public void start() {
        Customer customer = new Customer();
        customer.newCustomer();
    }


    public void mainMenu(String name, int password)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Re-enter the details of your new account!");
        String givenName = "";
        while (!(givenName.equals(name)))  {
            System.out.print("Enter your name: ");
            givenName = scan.nextLine();
            if (!(givenName.equals(name)))  {
                System.out.println("\nCannot find name in the database. Try Again");
            }
        }
        int repeat = -1;
        while (repeat == -1)    {
            System.out.print("Enter your pin: ");
            int pin = scan.nextInt();
            if (pin == password)   {
                repeat = 0;
            } else {
                System.out.print("Wrong pin. Please try again. ");
                System.out.println(" ");
            }
        }
        System.out.println("");
        System.out.print("Welcome to the ATM! ");
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
        if (option == 1)    {
            customer.withDraw();
        }

        if (option == 2)    {
            customer.deposit();
        }

        if (option == 3)    {
            customer.transferMoney();
        }


    }
}


