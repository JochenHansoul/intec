package com.example.cleaninghouse.config;

import com.example.cleaninghouse.service.CleaningRobot;
import com.example.cleaninghouse.service.CleaningService;
import com.example.cleaninghouse.service.tool.Broom;
import com.example.cleaninghouse.service.tool.Swiffer;
import com.example.cleaninghouse.service.tool.VacuumCleaner;
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