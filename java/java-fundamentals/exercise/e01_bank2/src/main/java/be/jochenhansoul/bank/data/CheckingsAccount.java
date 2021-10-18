package be.jochenhansoul.bank.data;

import java.util.ArrayList;

public class CheckingsAccount extends BankAccount{
    public CheckingsAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList<>());
    }

    public CheckingsAccount(String id, Person owner, String currency, ArrayList<Integer> proxies) {
        super(id, owner, currency, proxies);
    }
}
