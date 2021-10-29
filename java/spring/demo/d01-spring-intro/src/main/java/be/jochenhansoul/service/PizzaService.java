package be.jochenhansoul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaService {
    private Oven oven;

    public PizzaService(@Qualifier("StoneOven") Oven oven) {
        this.oven = oven;
        System.out.println("creating a pizza service");
    }

    public void bakePizza() {
        this.oven.bakePizza();
    }
}
