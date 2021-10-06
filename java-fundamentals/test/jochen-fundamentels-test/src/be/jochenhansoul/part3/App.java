package be.jochenhansoul.part3;

import be.jochenhansoul.part2.*;

public class App {
    public static void main(String[] args) {
        Milk milk = new Milk();
        SoyMilk soyMilk = new SoyMilk();
        Expresso expresso = new Expresso();
        Latte latte = new Latte(milk);

        System.out.println("milk: " + milk.getTemperature());
        System.out.println("soyMilk: " + soyMilk.getTemperature());
        System.out.println("expresso: " + expresso.getTemperature());
        System.out.println("latte: " + latte.getTemperature());
    }
}
