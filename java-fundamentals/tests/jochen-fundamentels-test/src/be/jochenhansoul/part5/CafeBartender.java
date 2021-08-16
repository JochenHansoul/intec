package be.jochenhansoul.part5;

import be.jochenhansoul.part3.Drinkable;
import be.jochenhansoul.part4.Bartender;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CafeBartender implements Bartender {
    private final List<String> MENU = new ArrayList<>(Arrays.asList("Espresso", "Latte", "Milk", "SoyMilk"));
    List<Drinkable> drinks = new ArrayList<>();

    public void showMenu() {
        MENU.forEach(System.out::println);
    }

    public void addDrinkable(Drinkable drink) {
        this.drinks.add(drink);
    }

    public Integer calculateTotal() {
        return drinks.stream()
            .map(drink -> drink.getPrice() * 2)
            .reduce(0, Integer::sum);
    }

    public void printTicket() {
        drinks.stream()
            .map(drink -> drink.getName() + " " + drink.getPrice() * 2 + " euro")
            .sorted()
            .forEach(System.out::println);
        System.out.println("total price: " + this.calculateTotal() + " euro");
    }
}
