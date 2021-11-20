package com.example.cleaninghouse.config;

import com.example.cleaninghouse.service.*;
import com.example.cleaninghouse.service.tool.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class BeanFactory {
    @Value("${language.language}")
    private static String language;
    @Value("${language.country}")
    private static String country;
    private static final Locale locale = new Locale("fr", "FR");
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle", locale);

    @Bean
    public CleaningService createBroomCleaningService() {
        return new CleaningService(new Broom(resourceBundle));
    }

    @Bean
    public CleaningService createSwifferCleaningService() {
        return new CleaningService(new Swiffer());
    }

    @Bean
    public CleaningService createVacuumCleanerCleaningService() {
        return new CleaningService(new VacuumCleaner());
    }

    @Bean
    public CleaningRobot createCleaningRobot() {
        return new CleaningRobot(Arrays.asList(new Broom(resourceBundle), new VacuumCleaner(), new Swiffer()));
    }

    @Bean
    public GardenService createLawnMowerGardenService() {
        return new GardenService(new LawnMower());
    }

    @Bean
    public GardenService createSpadeGardenService() {
        return new GardenService(new Spade());
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