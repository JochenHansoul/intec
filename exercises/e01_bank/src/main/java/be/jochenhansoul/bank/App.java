package be.jochenhansoul.bank;

import java.time.LocalDate;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Address address1 = new Address("straat", 1, "", 1000, "Alken", "Belgie");
        Person person1 = new Person(1, "first", "last", LocalDate.of(200, 10, 1), address1);
        Address address2 = new Address("straat", 1, "", 10, "Wellen", "Belgie");
        Person person2 = new Person(2, "jochen", "hansoul", LocalDate.of(1990, 5, 11), address2);

        BankAccountService bankService = new BankAccountService();
        bankService.addBankAccount(new BankAccount("BE11111111", person1, "euro"));
        bankService.addBankAccount(new BankAccount("BE22222222", person1, "euro"));
        bankService.addBankAccount(new BankAccount("BE33333333", person2, "euro"));
        bankService.addBankAccount(new BankAccount("BE44444444", person2, "euro"));

        try {
            bankService.deposit("BE11111111", person1, new BigDecimal("1000"), "euro");
            System.out.println("account 1 before transfer: " + bankService.getBalance("BE11111111"));
            bankService.transfer("BE11111111", "BE33333333", person1, new BigDecimal("250"), "euro");
            System.out.println("account 1: " + bankService.getBalance("BE11111111"));
            System.out.println("account 2: " + bankService.getBalance("BE33333333"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
