package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class Swiffer extends CleaningTool {
    ResourceBundle resourceBundle;

    public Swiffer(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.swiffer.use"));
    }
}
