package be.jochenhansoul.bank;

import java.math.BigDecimal;

public class BankAccount {
    String id;
    Person owner;
    String currency;
    Person[] proxies;
    int lowerLimit = 0;
    BigDecimal balance = BigDecimal.valueOf(0);
    String[] history = new String[0];

    public BankAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new Person[0]);
    }

    public BankAccount(
        String id,
        Person owner,
        String currency,
        Person[] proxies) {

        this.id = id;
        this.owner = owner;
        this.currency= currency;
        this.proxies = proxies;
    }

    public String getId() {
        return this.id;
    }

    public Person getOwner() {
        return this.owner;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Person[] getProxies() {
        return this.proxies;
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }
    
    public BigDecimal getBalance() {
        return this.balance;
    }

    public String[] getHistory() {
        return this.history;
    }

    @Override
    public String toString() {
        return this.id + " " + this.owner;
    }
}
