/*
Records all bank transactions and prevent that manipulation after the act cannot take place.
If no bankAccount is given then the person had deposited or widrawed money but not transferred
it to another account.
*/

package be.jochenhansoul.bank.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    public final LocalDateTime TIME;
    public final Person PERSON;
    public final BigDecimal AMOUNT;
    public final String CURRENCY;
    public final BankAccount ACCOUNT;

    public Transaction(Person person, BigDecimal amount, String currency) {
        this(person, amount, currency, null);
    }

    public Transaction(Person person, BigDecimal amount, String currency, BankAccount bankAccount) {
        this.TIME = LocalDateTime.now();
        this.PERSON = person;
        this.AMOUNT = amount;
        this.CURRENCY = currency;
        this.ACCOUNT = bankAccount;
    }
    
    public String toString() {
        return this.TIME + " " + this.PERSON + " " + this.AMOUNT + " " + this.CURRENCY + " " + this.ACCOUNT;
    }
}
