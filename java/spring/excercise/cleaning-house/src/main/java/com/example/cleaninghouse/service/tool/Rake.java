package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class Rake extends GardeningTool {
    ResourceBundle resourceBundle;

    public Rake(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.rake.use"));
    }
}
