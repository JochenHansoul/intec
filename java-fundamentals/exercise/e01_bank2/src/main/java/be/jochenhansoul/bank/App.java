package be.jochenhansoul.bank;

import be.jochenhansoul.bank.data.*;
import be.jochenhansoul.bank.service.BankAccountService;
import be.jochenhansoul.bank.service.PersonFactory;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // making data
        Address address1 = new Address("straat", 1, "", 1000, "Alken", "Belgie");
        Address address2 = new Address("straat2", 2, "", 2000, "Herk", "Belgie");
        Person person1 = new Customer(1, "first", "last", address1, LocalDate.of(2000, 1, 1));
        Person person2 = new Customer(2, "jochen", "hansoul", address2, LocalDate.of(2001, 2, 2));

        // factory testing
        /*Person factoryPerson = PersonFactory.createPerson(scanner);
        System.out.println(factoryPerson);*/

        try {
            BankAccountService bankAccountService = new BankAccountService();

            System.out.println("test investment account");
            InvestmentAccount investmentAccount = new InvestmentAccount("BE11111111", person1, "euro");
            investmentAccount.deposit(person1, new BigDecimal("1000"), "Euro");
            investmentAccount.addProfit();
            System.out.println(investmentAccount.getBalance());

            System.out.println("testing withdraw");
            bankAccountService.addBankAccount(new CheckingsAccount("BE11111112", person1, "euro"));
            bankAccountService.deposit("BE11111112",  person1, new BigDecimal("100"), "euro");
            bankAccountService.withdraw("BE11111112",  person1, new BigDecimal("50"), "euro");
            System.out.println(bankAccountService.getBalance("BE11111112"));
            System.out.println("testing withdraw investment account throw exception");
            bankAccountService.addBankAccount(investmentAccount);
            bankAccountService.withdraw("BE11111111", person1, new BigDecimal("100"), "euro");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
