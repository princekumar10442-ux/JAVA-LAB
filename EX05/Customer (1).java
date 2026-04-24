import java.util.*;

public class Customer {
    int id;
    String name;
    ArrayList<Account> accounts;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
    }

    void addAccount(Account acc) {
        accounts.add(acc);
    }
}
