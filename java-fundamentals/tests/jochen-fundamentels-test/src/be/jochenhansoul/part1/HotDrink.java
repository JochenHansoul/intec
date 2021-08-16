package be.jochenhansoul.part1;

public abstract class HotDrink extends Drink {
    private String name;
    private Integer price;
    private Integer temperature;

    public HotDrink() {
        this("Hot Drink", 2, 75);
    }

    public HotDrink(String name, Integer price, Integer temperature) {
        super(name, price);
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return this.temperature;
    }

    @Override
    public String toString() {
        return super.toString() + ", temperature: " + this.temperature;
    }
}
