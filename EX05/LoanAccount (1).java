public class LoanAccount extends Account {

    LoanAccount(int accNo, double loan) {
        super(accNo, loan, "Loan");
    }

    @Override
    void deposit(double amt) {
        balance -= amt;
        System.out.println("[Loan] Repayment of: " + amt +
                " | Remaining Loan: " + balance);
    }

    @Override
    void withdraw(double amt) {
        balance += amt;
        System.out.println("[Loan] Loan Disbursed: " + amt +
                " | Total Loan Owed: " + balance);
    }
}
