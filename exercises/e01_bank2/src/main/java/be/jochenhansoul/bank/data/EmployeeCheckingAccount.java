package be.jochenhansoul.bank.data;

import java.util.ArrayList;

public class EmployeeCheckingAccount extends CheckingsAccount{
    public EmployeeCheckingAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList<>());
    }

    public EmployeeCheckingAccount(String id, Person owner, String currency, ArrayList<Integer> proxies) {
        super(id, owner, currency, proxies);
    }
}
