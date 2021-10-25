package be.jochenhansoul.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StoneOven implements Oven {

    @Override
    public void bakePizza() {
        System.out.println("baking pizza");
    }
}
