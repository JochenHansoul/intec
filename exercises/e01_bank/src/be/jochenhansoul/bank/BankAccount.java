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
    
    public String getBalance() {
        return this.balance.toString();
    }

    public void deposit(Person person, BigDecimal amount, String currency) {
        if (eligiblePerson(person)) {
            transactions.add(new Transaction(person, amount, currency));
            this.balance = this.balance.add(amount);
        }
        // maybe add exception
    }

    public void widraw(Person person, BigDecimal amount, String currency) {
        if (eligiblePerson(person) && enoughBalance(amount)) {
            transactions.add(new Transaction(person, amount, currency));
            this.balance = this.balance.subtract(amount);
        }
        // maybe add exception
    }

    public void transfer(
        Person person,
        BigDecimal amount,
        String currency,
        BankAccount account) throws Exception {

        if (eligiblePerson(person)) {
            BigDecimal n = new BigDecimal(0);
            BigDecimal negativeAmount = amount.multiply(new BigDecimal(-1));
            if (negativeAmount.compareTo(n) > 0) {
                this.balance = this.balance.add(negativeAmount);
            } else if (amount.compareTo(n) < 0) {
                if (enoughBalance(amount)) {
                    this.balance = this.balance.subtract(negativeAmount);
                }
                // maybe add exception
            } else {
                throw new Exception("amount may not be 0");
            }
            transactions.add(new Transaction(person, negativeAmount, currency, account));
        }
        // maybe add exception
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
