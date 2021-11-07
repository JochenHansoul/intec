package com.example.cleaninghouse.service;

import com.example.cleaninghouse.service.tool.CleaningTool;

public class CleaningService implements CleanServiceable {
    private CleaningTool cleaningTool;

    public CleaningService(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }

    @Override
    public void clean() {
        this.cleaningTool.use();
    }
}
