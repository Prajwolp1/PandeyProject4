public class Account {


    private double currentBalance;

    public Account() {
        currentBalance = 0;
    }

    public double getCurrentBalance()   {
        return currentBalance;
    }


    public void addMoney(double add) {
        currentBalance += add;
    }

    public void loseMoney(double lose) {
        currentBalance -= lose;
    }
}
