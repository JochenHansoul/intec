package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class Broom extends CleaningTool {
    ResourceBundle resourceBundle;

    public Broom(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.broom.use"));
    }
}
