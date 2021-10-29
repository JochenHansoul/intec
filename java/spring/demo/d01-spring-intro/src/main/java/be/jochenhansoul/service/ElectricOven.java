package be.jochenhansoul.service;

import org.springframework.stereotype.Component;

@Component
public class ElectricOven implements Oven {
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
        System.out.printf("baking %d pizza(s) on %d degree, Bzzzzzzzzzzzzzzzzzzzzzz",
                this.amountOfPizzas, this.temperature);
    }
}
