package be.jochenhansoul;

import be.jochenhansoul.service.PizzaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class D01SpringIntroApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(D01SpringIntroApplication.class, args);

		PizzaService pizzaService = context.getBean(PizzaService.class);
		pizzaService.bakePizza();
	}
}
