package be.jochenhansoul.bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    public final String ID;

    private Person owner;
    private String currency;
    private List<Person> proxies;
    private int lowerLimit = 0;
    private BigDecimal balance = BigDecimal.valueOf(0);
    private List<Transaction> transactions = new ArrayList();

    public BankAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList());
    }

    public BankAccount(
        String id,
        Person owner,
        String currency,
        ArrayList proxies) {

        this.ID = id;
        this.owner = owner;
        this.currency= currency;
        this.proxies = proxies;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Person getOwner() {
        return this.owner;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Person[] getProxies() {
        return this.proxies.toArray(new Person[0]).clone();
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
        this.proxies.add(person);
    }

    public void removeProxie(int i) {
        this.proxies.remove(i);
    }

    @Override
    public String toString() {
        return this.ID + " " + this.owner;
    }

    private boolean checkPerson(Person person) {
        return this.owner.equals(person) || this.proxies.contains(person);
    }
}
