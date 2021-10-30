package be.jochenhansoul.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElectricOven extends Oven {
    public ElectricOven(@Value("${electric.oven.temperature}") Integer temperature) {
        super(temperature);
    }

    @Override
    public void bake(String food, int amount) {
        System.out.printf("baking %d %s(s) on %d degree, Bzzzzzzzzzzzzzzzzzzzzzz",
                amount, food, super.getTemperature());
    }
}
