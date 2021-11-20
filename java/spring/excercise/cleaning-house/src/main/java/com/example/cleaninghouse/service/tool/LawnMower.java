package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class LawnMower extends GardeningTool {
    ResourceBundle resourceBundle;

    public LawnMower(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.lawnmower.use"));
    }
}
