public class SavingsAccount extends Account {
    double rate;

    SavingsAccount(int accNo, double balance, double rate) {
        super(accNo, balance, "Savings");
        this.rate = rate;
    }

    @Override
    void deposit(double amt) {
        balance += amt;
        System.out.println("[Savings] Deposited: " + amt +
                " | Balance: " + balance +
                " | Interest Rate: " + rate + "%");
    }

    @Override
    void withdraw(double amt) {
        if (balance - amt < 500) {
            System.out.println("[Savings] Cannot withdraw! Minimum balance of 500 must be maintained.");
        } else {
            balance -= amt;
            System.out.println("[Savings] Withdrawn: " + amt +
                    " | Balance: " + balance);
        }
    }
}