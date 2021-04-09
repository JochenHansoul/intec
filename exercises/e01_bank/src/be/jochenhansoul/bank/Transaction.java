/*
Records all bank transactions and prevent that manipulation after the act cannot take place.
If no bankAccount is given then the person had deposited or widrawed money but not transferred
it to another account.
*/

package be.jochenhansoul.bank;

import java.math.BigDecimal;

public class Transaction {
    private Person person;
    private BigDecimal amount;
    private String currency;
    private BankAccount bankAccount;

    public Transaction(Person person, BigDecimal amount, String currency) {
        this(person, amount, currency, null);
    }

    public Transaction(Person person, BigDecimal amount, String currency, BankAccount bankAccount) {
        this.person = person;
        this.amount = amount;
        this.currency = currency;
        this.bankAccount = bankAccount;
    }
    
    public String  getPerson() {
        return this.person.toString();
    }

    public String getAmount() {
        return this.amount.toString();
    }

    public String getCurrency() {
        return this.currency;
    }

    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    @Override
    public String toString() {
        return this.person + " " + this.amount + " " + this.currency + " " + this.bankAccount;
    }
}
