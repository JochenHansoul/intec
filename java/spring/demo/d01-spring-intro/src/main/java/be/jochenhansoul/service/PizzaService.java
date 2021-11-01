package be.jochenhansoul.service;

public class PizzaService {
    private Oven oven;
    private Integer amountOfPizzas;

    public PizzaService(Oven oven, Integer amountOfPizzas) throws Exception {
        if (amountOfPizzas < 0) {
            throw new Exception("amount of pizza's may not be below zero");
        } else {
            this.oven = oven;
            this.amountOfPizzas = amountOfPizzas;
            System.out.println("creating a pizza service");
        }
    }

    public Integer getAmountOfPizzas() {
        return this.amountOfPizzas;
    }

    public void addPizza(int amount) throws Exception {
        if (amount < 0) {
            throw new Exception("amount may not be lower then zero");
        } else {
            this.amountOfPizzas += amount;
        }
    }

    public void bakePizza(int amount) throws Exception {
        if (amount > this.amountOfPizzas) {
            throw new Exception("Not enough pizza's in storage");
        } else {
            this.oven.bake("pizza", amount);
            this.amountOfPizzas -= amount;
        }
    }
}
