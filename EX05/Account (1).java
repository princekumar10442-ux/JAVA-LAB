public class Account {
    int accNo;
    double balance;
    String type;

    Account(int accNo, double balance, String type) {
        this.accNo = accNo;
        this.balance = balance;
        this.type = type;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) {
        if (amt > balance)
            System.out.println("Insufficient balance");
        else
            balance -= amt;
    }
}