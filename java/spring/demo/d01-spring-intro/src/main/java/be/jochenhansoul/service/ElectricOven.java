package be.jochenhansoul.service;

import org.springframework.stereotype.Component;

@Component
public class ElectricOven implements Oven {
    @Override
    public void bakePizza() {
        System.out.println("baking pizza. Bzzzzzzzzzzzzzzzzzzzzzz");
    }
}
