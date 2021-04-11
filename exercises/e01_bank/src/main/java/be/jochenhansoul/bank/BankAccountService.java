package be.jochenhansoul.bank;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class BankAccountService {
    private List<BankAccount> accounts = new ArrayList();

    public void addBankAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public BigDecimal getBalance(String id) throws Exception {
        BankAccount account = getAccount(id);
        return account.getBalance();
    }

    public void deposit(String id, Person person, BigDecimal amount, String currency) throws Exception {
        BankAccount account = getAccount(id);
        account.deposit(person, amount, currency);
    }

    public void withdraw(String id, Person person, BigDecimal amount, String currency) throws Exception {
        BankAccount account = getAccount(id);
        account.withdraw(person, amount, currency);
    }

    public void transfer(String idSource, String idTarget, Person person, BigDecimal amount, String currency) throws Exception {
        BankAccount source = getAccount(idSource);
        BankAccount target = getAccount(idTarget);
        source.transfer(person, amount.multiply(new BigDecimal("-1")), currency, target);
        target.transfer(person, amount, currency, source);
    }

    private BankAccount getAccount(String id) throws Exception {
        BankAccount[] accounts = this.accounts.toArray(new BankAccount[0]);
        BankAccount account = null;
        int counter = 0;
        boolean found = false;
        while (!found && counter < accounts.length) {
            if (id.equals(accounts[counter].BANK_ID)) {
                account = accounts[counter];
                found = true;
            } else {
                counter++;
            }
        }
        if (account != null) {
            return account;
        } else {
            throw new Exception("Account not found");
        }
    }
}

