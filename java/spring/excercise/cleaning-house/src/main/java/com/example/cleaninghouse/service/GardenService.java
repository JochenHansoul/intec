package com.example.cleaninghouse.service;

import com.example.cleaninghouse.service.tool.GardeningTool;

public class GardenService implements GardenServiceable {
    private GardeningTool gardeningTool;

    public GardenService(GardeningTool gardenTool) {
        this.gardeningTool = gardenTool;
    }

    @Override
    public void garden() {
        this.gardeningTool.use();
    }
}
