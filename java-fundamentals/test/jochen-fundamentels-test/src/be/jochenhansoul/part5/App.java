package be.jochenhansoul.part5;

import be.jochenhansoul.part2.*;

public class App {
    public static void main(String[] args) {
        CafeBartender cafe = new CafeBartender();
        cafe.showMenu();
        System.out.println();

        cafe.addDrinkable(new Milk());
        cafe.addDrinkable(new SoyMilk());
        cafe.addDrinkable(new Expresso());
        cafe.addDrinkable(new Expresso());
        cafe.addDrinkable(new Latte(new Milk()));
        cafe.printTicket();
    }
}
