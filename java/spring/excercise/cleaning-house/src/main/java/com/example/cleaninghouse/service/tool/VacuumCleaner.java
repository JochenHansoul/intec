package com.example.cleaninghouse.service.tool;

import java.util.ResourceBundle;

public class VacuumCleaner extends CleaningTool {
    ResourceBundle resourceBundle;

    public VacuumCleaner(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.vacuum.cleaner.use"));
    }
}
