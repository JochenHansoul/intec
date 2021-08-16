package be.jochenhansoul.part2;

import be.jochenhansoul.part1.*;

public abstract class MixedDrink extends Drink {
    private HotDrink hotDrink;
    private ColdDrink coldDrink;
    Integer percentage;

    public MixedDrink(
        String name,
        HotDrink hotDrink,
        ColdDrink coldDrink,
        Integer percentage) {
        super(name, hotDrink.getPrice() + coldDrink.getPrice());
        this.hotDrink = hotDrink;
        this.coldDrink = coldDrink;
        this.percentage = percentage;
    }

    public Integer calcTemperature() {
        return (this.hotDrink.getTemperature() * this.percentage + 10 * (100 - this.percentage)) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s%nhot drink: {%s}%ncold drink: {%s}%npercentage: %d",
            super.toString(),
            this.hotDrink,
            this.coldDrink,
            this.percentage);
    }
}
