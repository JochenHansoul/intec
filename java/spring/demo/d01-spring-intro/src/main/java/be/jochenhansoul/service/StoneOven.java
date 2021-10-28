package be.jochenhansoul.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "StoneOven")
public class StoneOven implements Oven {
    private int amountOfPizzas;
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
        System.out.printf("baking %d pizza on %d degrees", this.amountOfPizzas, this.temperature);
    }
}
