package be.jochenhansoul.cleaninghouse.config;

import be.jochenhansoul.cleaninghouse.service.CleaningRobot;
import be.jochenhansoul.cleaninghouse.service.CleaningService;
import be.jochenhansoul.cleaninghouse.service.tool.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

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
}