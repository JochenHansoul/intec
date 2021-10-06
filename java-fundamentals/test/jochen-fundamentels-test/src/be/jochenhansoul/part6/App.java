package be.jochenhansoul.part6;

import be.jochenhansoul.part2.*;

public class App {
    public static void main(String[] args) {
        BistroBartender bistro = new BistroBartender();
        bistro.showMenu();
        System.out.println();

        bistro.addDrinkable(new Milk());
        bistro.addDrinkable(new SoyMilk());
        bistro.addDrinkable(new Expresso());
        bistro.addDrinkable(new Expresso());
        bistro.addDrinkable(new Latte(new Milk()));
        bistro.addDrinkable(new Latte(new Milk()));
        bistro.printTicket();
    }
}
