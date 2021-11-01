package be.jochenhansoul.service;

public class ElectricOven extends Oven {
    public ElectricOven(Integer temperature) {
        super(temperature);
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree, Bzzzzzzzzzzzzzzzzzzzzzz",
                amount, food, super.getTemperature());
    }
}
