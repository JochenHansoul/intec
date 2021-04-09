package be.jochenhansoul.bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    public final String BANK_ID;
    public final int OWNER_ID;

    private List<Integer> proxies;
    private String currency;
    private BigDecimal balance = BigDecimal.valueOf(0);
    private int lowerLimit = 0;
    private List<Transaction> transactions = new ArrayList();

    public BankAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList());
    }

    public BankAccount(
        String id,
        Person owner,
        String currency,
        ArrayList proxies) {

        this.BANK_ID = id;
        this.OWNER_ID = owner.ID;
        this.currency= currency;
        this.proxies = proxies;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getOwner() {
        return this.OWNER_ID;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Integer[] getProxies() {
        return this.proxies.toArray(new Integer[0]).clone();
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }
    
    public String getBalance() {
        return this.balance.toString();
    }

    public void deposit(Person person, String amount) {
        // todo
        this.balance.add(new BigDecimal(amount));
    }

    public void widraw(String amount) {
        // todo
        BigDecimal toBeSubtracted = new BigDecimal(amount);
        if (this.balance.subtract(toBeSubtracted).compareTo(new BigDecimal(this.lowerLimit)) >= 0) {
            this.balance.subtract(toBeSubtracted);
        } else {
            // todo
        }
    }

    public Transaction[] getTransactions() {
        return this.transactions.toArray(new Transaction[0]).clone();
    }

    public void addProxie(Person person) {
        this.proxies.add(person.ID);
    }

    public void removeProxie(int i) {
        this.proxies.remove(i);
    }

    @Override
    public String toString() {
        return this.BANK_ID + " owner: " + this.OWNER_ID;
    }

    private boolean checkPerson(Person person) {
        return this.OWNER_ID == person.ID || this.proxies.contains(person.ID);
    }
}
