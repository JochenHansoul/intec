package be.jochenhansoul.bank.data;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList<>());
    }

    public SavingsAccount(String id, Person owner, String currency, ArrayList<Integer> proxies) {
        super(id, owner, currency, proxies);
    }

    public void addInterest() throws Exception {
        BigDecimal balance = getBalance();
        this.addInterestPercent(balance.multiply(new BigDecimal("0.02")));
    }
}
