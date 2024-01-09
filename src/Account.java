public class Account {


    private double currentBalance;

    public Account() {
        currentBalance = 0;
    }


    public void addMoney(double add) {
        currentBalance += add;
    }

    public void loseMoney(double lose) {
        currentBalance -= lose;
    }
}
