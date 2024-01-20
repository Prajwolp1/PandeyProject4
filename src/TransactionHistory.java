public class TransactionHistory {

    //creates instance variables
    private String history;
    private int a;
    private int s;

    //initializes all the instances variables
    public TransactionHistory() {
        this.history = "";
        a = 0;
        s = 0;
    }

    //gets the history of receipts
    public String getHistory()  {
        return history;
    }

    //called when deposits, transfers and with drawls happen and increments by 1 each time
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

    //called when pin changes and transaction is checked happen and increments by 1 each time
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

    //adds all the A-receipts and all the S-receipts into one long history of receipts
    public void addToHistory(String newAction)  {
        history += "\n" + newAction;
    }



}
