package be.jochenhansoul.service;

public class StoneOven extends Oven {
    public StoneOven(Integer temperature) {
        super(temperature);
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree", amount, food, super.getTemperature());
    }
}
