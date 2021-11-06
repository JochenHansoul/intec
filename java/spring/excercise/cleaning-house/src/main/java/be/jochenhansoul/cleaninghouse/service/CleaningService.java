package be.jochenhansoul.cleaninghouse.service;

import be.jochenhansoul.cleaninghouse.service.tool.Usable;

public class CleaningService implements CleanServiceable {
    private Usable cleaningTool;

    public CleaningService(Usable cleaningTool) {
        this.cleaningTool = cleaningTool;
    }

    @Override
    public void clean() {
        this.cleaningTool.use();
    }
}
