package com.example.cleaninghouse.service;

import javax.annotation.PostConstruct;

public class DomesticService implements DomesticServiceable {
    private CleanServiceable cleanService;
    private GardenServiceable gardenService;

    public DomesticService(CleanServiceable cleanService, GardenService gardenService) {
        this.cleanService = cleanService;
        this.gardenService = gardenService;
    }

    @PostConstruct
    @Override
    public void runHousehold() {
        this.cleanService.clean();
        this.gardenService.garden();
    }
}
