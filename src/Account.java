public class Account {

    //creates the balance of the checkings and savings account
    private double currentBalance;

    //initializes the balance of the checkings and savings account
    public Account() {
        currentBalance = 0;
    }

    //gets the balance of the account
    public double getCurrentBalance()   {
        return currentBalance;
    }

    //adds money to the account
    public void addMoney(double add) {
        currentBalance += add;
    }

    //reduces money from the account
    public void loseMoney(double lose) {
        currentBalance -= lose;
    }
}
