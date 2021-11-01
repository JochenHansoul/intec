package be.jochenhansoul.config;

import be.jochenhansoul.service.ElectricOven;
import be.jochenhansoul.service.PizzaService;
import be.jochenhansoul.service.StoneOven;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {
    @Value("${electric.oven.temperature}")
    private Integer electricOvenTemperature;
    @Value("${stone.oven.temperature}")
    private Integer stoneOvenTemperature;
    @Value("${pizza.amount}")
    private Integer pizzaAmount;

    @Bean
    public ElectricOven createElectricOven() {
        return new ElectricOven(this.electricOvenTemperature);
    }

    @Bean
    public StoneOven createStoneOven() {
        return new StoneOven(this.stoneOvenTemperature);
    }

    @Bean
    public PizzaService createPizzaService() throws Exception {
        return new PizzaService(this.createStoneOven(), this.pizzaAmount);
    }
}
