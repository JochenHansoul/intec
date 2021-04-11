package be.jochenhansoul.bank;

import java.time.LocalDate;

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
            System.out.println(bankService.getBalance("BE11111111"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
