package be.jochenhansoul.bank.data;

import java.util.ArrayList;

public class EmployeeSavingsAccount extends SavingsAccount{
    public EmployeeSavingsAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList<>());
    }

    public EmployeeSavingsAccount(String id, Person owner, String currency, ArrayList<Integer> proxies) {
        super(id, owner, currency, proxies);
    }
}
