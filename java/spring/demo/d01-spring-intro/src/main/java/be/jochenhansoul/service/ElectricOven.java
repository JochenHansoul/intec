package be.jochenhansoul.service;

import org.springframework.stereotype.Component;

@Component
public class ElectricOven implements Oven {
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree, Bzzzzzzzzzzzzzzzzzzzzzz",
                amount, food, this.temperature);
    }
}
