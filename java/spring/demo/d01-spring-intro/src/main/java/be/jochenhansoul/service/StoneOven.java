package be.jochenhansoul.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "StoneOven")
public class StoneOven implements Oven {
    @Value("${stone.oven.temperature}")
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree", amount, food, this.temperature);
    }
}
