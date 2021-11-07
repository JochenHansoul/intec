package com.example.cleaninghouse.service;

import javax.annotation.PostConstruct;
import java.util.List;

public class DomesticService implements DomesticServiceable {
    private List<CleanServiceable> cleanServices;
    private List<GardenServiceable> gardenServices;

    public DomesticService(List<CleanServiceable> cleanServices, List<GardenServiceable> gardenServices) {
        this.cleanServices = cleanServices;
        this.gardenServices = gardenServices;
    }

    @PostConstruct
    @Override
    public void runHousehold() {
        for (CleanServiceable cleanServiceable : this.cleanServices) {
            cleanServiceable.clean();
        }
        for (GardenServiceable gardenServiceable : this.gardenServices) {
            gardenServiceable.garden();
        }
    }
}
