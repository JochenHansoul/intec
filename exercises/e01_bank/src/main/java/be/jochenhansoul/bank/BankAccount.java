package be.jochenhansoul.bank;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccount {
    public final String BANK_ID;
    public final int OWNER_ID;
    public final LocalDateTime CREATION_DATE;

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
        this.CREATION_DATE = LocalDateTime.now();
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
    
    public BigDecimal getBalance() {
        return this.balance;
    }

    public void deposit(Person person, BigDecimal amount, String currency) throws Exception {
        if (eligiblePerson(person)) {
            transactions.add(new Transaction(person, amount, currency));
            this.balance = this.balance.add(amount);
        } else {
            throw new Exception("person is not eligible to deposit money");
        }
    }

    public void withdraw(Person person, BigDecimal amount, String currency) throws Exception {
        if (eligiblePerson(person) && enoughBalance(amount)) {
            transactions.add(new Transaction(person, amount, currency));
            this.balance = this.balance.subtract(amount);
        } else {
            throw new Exception("person is not eligible to withdraw money");
        }
    }

    public void transfer(
        Person person,
        BigDecimal amount,
        String currency,
        BankAccount account) throws Exception {

        BigDecimal bigNull = new BigDecimal(0);
        if (amount.compareTo(bigNull) == 0) {
            throw new Exception("amount may not be 0");
        } else if (amount.compareTo(bigNull) < 0) {
            if (!eligiblePerson(person)) {
                throw new Exception("person is not eligible to make a transfer");
            } else if (!enoughBalance(amount)) {
                throw new Exception("not enough balance");
            }
        }
        this.balance = this.balance.add(amount);
        transactions.add(new Transaction(person, amount, currency, account));
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

    private boolean eligiblePerson(Person person) {
        return this.OWNER_ID == person.ID || this.proxies.contains(person.ID);
    }

    private boolean enoughBalance(BigDecimal amount) {
        return this.balance.subtract(amount).compareTo(new BigDecimal(this.lowerLimit)) >= 0;
    }
}
