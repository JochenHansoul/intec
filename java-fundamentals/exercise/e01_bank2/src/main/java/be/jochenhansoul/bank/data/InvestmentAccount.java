package be.jochenhansoul.bank.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class InvestmentAccount extends BankAccount {
    public InvestmentAccount(String id, Person owner, String currency) {
        this(id, owner, currency, new ArrayList<>());
    }

    public InvestmentAccount(String id, Person owner, String currency, ArrayList<Integer> proxies) {
        super(id, owner, currency, proxies);
    }

    public void addProfit() {
        Random rand = new Random(5);
        int number = rand.nextInt(11) - 5;
        BigDecimal percent = new BigDecimal("" + number).divide(new BigDecimal("100"), 2);
        super.addInterestPercent(percent);
    }
}
