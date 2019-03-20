package sicily.com.androidlist;

public class Account {
    private String names;
    private String accnumber;
    private double balance;

    public Account(String names, String accnumber, double balance) {
        this.names = names;
        this.accnumber = accnumber;
        this.balance = balance;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}