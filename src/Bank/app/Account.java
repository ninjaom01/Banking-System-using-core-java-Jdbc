package Bank.app;

public class Account {

    int accNo;
    String name;
    String address;
    String accType;
    double balance;
    double minBalance;

    public Account(int accNo, String name, String address,
                   String accType, double balance, double minBalance) {

        this.accNo = accNo;
        this.name = name;
        this.address = address;
        this.accType = accType;
        this.balance = balance;
        this.minBalance = minBalance;
    }
}
