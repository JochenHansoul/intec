package be.jochenhansoul.part2;

import be.jochenhansoul.part1.ColdDrink;
import be.jochenhansoul.part3.Drinkable;

public class Latte extends MixedDrink {
    public Latte(ColdDrink coldDrink) {
        super("Latte", new Expresso(), coldDrink, 50);
    }
}
