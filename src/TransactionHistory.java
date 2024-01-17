public class TransactionHistory {

    private String history;
    private int a;
    private int s;
    public TransactionHistory() {
        this.history = "";
        a = 0;
        s = 0;
    }

    public void addToHistory(String newAction)  {
        history += "\n" + newAction;
    }
    public String getHistory()  {
        return history;
    }

    public String getATransaction() {
        a++;
        if (a / 100 == 0 && a / 10 ==0) {
            return "A000" + a;
        }
        if (a / 100 == 0 && a / 10 != 0)    {
            return "A00" + a;
        }
        else {
            return "A" + a;
        }
    }

    public String getSTransaction() {
        s++;
        if (s / 100 == 0 && s / 10 ==0) {
            return "S000" + s;
        }
        if (s / 100 == 0 && s / 10 != 0)    {
            return "S00" + s;
        }
        else {
            return "S" + s;
        }
    }



}
