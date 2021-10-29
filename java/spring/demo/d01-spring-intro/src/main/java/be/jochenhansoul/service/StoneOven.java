package be.jochenhansoul.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "StoneOven")
public class StoneOven implements Oven {
    @Value("${stone.oven.pizza.amount}")
    private int amountOfPizzas;
    @Value("${stone.oven.temperature}")
    private int temperature;

    public void setAmountOfPizzas(int amountOfPizzas) {
        this.amountOfPizzas = amountOfPizzas;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getAmountOfPizzas() {
        return amountOfPizzas;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void bakePizza() {
        System.out.printf("baking %d pizza(s) on %d degree", this.amountOfPizzas, this.temperature);
    }
}
