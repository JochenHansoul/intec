package be.jochenhansoul.bank;

import java.util.List;
import java.util.ArrayList;

public class BankAccountService {
    private List<BankAccount> accounts = new ArrayList();

    public void addBankAccount(BankAccount account) {
        this.accounts.add(account);
    }
}

