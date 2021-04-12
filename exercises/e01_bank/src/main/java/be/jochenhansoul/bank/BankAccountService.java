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

    public void deposit(String bankId, Person person, BigDecimal amount, String currency) throws Exception {
        if (amount.compareTo(new BigDecimal("0")) <= 0) {
            throw new Exception("amount must be higher then zero");
        } else {
            BankAccount account = getAccount(id);
            account.deposit(person, amount, currency);
        }
    }

    public void withdraw(String bankId, Person person, BigDecimal amount, String currency) throws Exception {
        if (amount.compareTo(new BigDecimal("0")) <= 0) {
            throw new Exception("amount must be higher then zero");
        } else {
            BankAccount account = getAccount(id);
            account.withdraw(person, amount, currency);
        }
    }

    public void transfer(String idSource, String idTarget, Person person, BigDecimal amount, String currency) throws Exception {
        if (idSource.equals(idTarget) {
            throw new Exception("source account may not be the same as target account");
        } else if (amount.compareTo(new BigDecimal("0")) <= 0) {
            throw new Exception("amount must be higher then zero");
        } else {
            BankAccount source = getAccount(idSource);
            BankAccount target = getAccount(idTarget);
            source.transfer(person, amount.multiply(new BigDecimal("-1")), currency, target);
            target.transfer(person, amount, currency, source);
        }
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

