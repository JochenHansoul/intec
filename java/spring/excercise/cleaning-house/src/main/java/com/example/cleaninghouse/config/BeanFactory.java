package com.example.cleaninghouse.config;

import com.example.cleaninghouse.service.*;
import com.example.cleaninghouse.service.tool.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
public class BeanFactory {
    @Bean
    public CleaningService createBroomCleaningService() {
        return new CleaningService(new Broom());
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
        return new CleaningRobot(Arrays.asList(new Broom(), new VacuumCleaner(), new Swiffer()));
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