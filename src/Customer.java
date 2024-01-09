
import java.util.Scanner;




public class Customer {
    private String customerName;
    private int customerPin;

    public Customer() {

    }


    public void setCustomerPin(int newPin)  {
        customerPin = newPin;
    }


    public void newCustomer() {
        Scanner scan = new Scanner(System.in);
        Account savingsAccount = new Account();
        Account checkingAccount = new Account();
        System.out.println("Welcome to the ATM! \nBefore We Start Please Create a New Account \nPlease Enter Name and Create a Pin. \n");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        customerName = name;
        System.out.print("Create a new pin for your account: ");
        int pin = scan.nextInt();
        customerPin = pin;
        ATM.mainMenu(customerName, customerPin);
    }
}
