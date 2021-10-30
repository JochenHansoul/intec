package be.jochenhansoul.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "StoneOven")
public class StoneOven extends Oven {
    public StoneOven(@Value("${stone.oven.temperature}") Integer temperature) {
        super(temperature);
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree", amount, food, super.getTemperature());
    }
}
