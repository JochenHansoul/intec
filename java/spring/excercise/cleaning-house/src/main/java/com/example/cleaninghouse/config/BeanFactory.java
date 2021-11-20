package com.example.cleaninghouse.config;

import com.example.cleaninghouse.service.*;
import com.example.cleaninghouse.service.tool.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class BeanFactory {
    private static final Locale LOCALE = new Locale("nl", "NL");
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("bundle", LOCALE);

    @Bean
    public CleaningService createBroomCleaningService() {
        return new CleaningService(new Broom(RESOURCE_BUNDLE));
    }

    @Bean
    public CleaningService createSwifferCleaningService() {
        return new CleaningService(new Swiffer(RESOURCE_BUNDLE));
    }

    @Bean
    public CleaningService createVacuumCleanerCleaningService() {
        return new CleaningService(new VacuumCleaner(RESOURCE_BUNDLE));
    }

    @Bean
    public CleaningRobot createCleaningRobot() {
        return new CleaningRobot(Arrays.asList(
                new Broom(RESOURCE_BUNDLE),
                new VacuumCleaner(RESOURCE_BUNDLE),
                new Swiffer(RESOURCE_BUNDLE)));
    }

    @Bean
    public GardenService createLawnMowerGardenService() {
        return new GardenService(new LawnMower(RESOURCE_BUNDLE));
    }

    @Bean
    public GardenService createSpadeGardenService() {
        return new GardenService(new Spade(RESOURCE_BUNDLE));
    }

    @Bean
    public DomesticService createDomesticService() {
        List<CleanServiceable> cleanServiceableList =
                Arrays.asList(this.createBroomCleaningService(), this.createCleaningRobot());
        List<GardenServiceable> gardenServiceableList =
                Arrays.asList(this.createSpadeGardenService(), this.createLawnMowerGardenService());
        return new DomesticService(cleanServiceableList, gardenServiceableList);
    }
}