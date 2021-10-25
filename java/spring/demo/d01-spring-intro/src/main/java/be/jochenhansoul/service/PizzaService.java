package be.jochenhansoul.service;

import org.springframework.stereotype.Component;

@Component
public class PizzaService {
    public PizzaService(Oven oven) {
        System.out.println("creating pizza service");
        oven.bakePizza();
    }
}
