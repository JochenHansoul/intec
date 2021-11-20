package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class Spade extends GardeningTool {
    ResourceBundle resourceBundle;

    public Spade(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.spade.use"));
    }
}
