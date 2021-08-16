package be.jochenhansoul.part6;

import be.jochenhansoul.part3.Drinkable;
import be.jochenhansoul.part4.Bartender;

import java.util.*;

public class BistroBartender implements Bartender {
    private final List<String> MENU = new ArrayList<>(Arrays.asList("Espresso", "Latte", "Milk", "SoyMilk"));

    private Map<Drinkable, Integer> drinks = new TreeMap<>(Comparator.comparingInt(Drinkable::getPrice));

    public void showMenu() {
        MENU.forEach(System.out::println);
    }

    public void addDrinkable(Drinkable drink) {
        if (!drinks.keySet().contains(drink)) {
            this.drinks.put(drink, 1);
        } else {
            this.drinks.put(drink, drinks.get(drink) + 1);
        }
    }

    public Integer calculateTotal() {
        Integer price = 0;
        for (Drinkable drink : this.drinks.keySet()) {
            price += drink.getPrice() * this.drinks.get(drink);
        }
        return price;
    }

    public void printTicket() {
        this.drinks.forEach((drink, amount) -> System.out.printf(
            "%d %s %d Euro: %d Euro%n",
            amount,
            drink.getName(),
            drink.getPrice(),
            drink.getPrice() * amount)
        );
        System.out.println("total price: " + calculateTotal() + " euro");
    }
}
