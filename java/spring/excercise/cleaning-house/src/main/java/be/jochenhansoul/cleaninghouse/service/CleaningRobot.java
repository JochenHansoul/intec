package be.jochenhansoul.cleaninghouse.service;

import be.jochenhansoul.cleaninghouse.service.tool.*;

import java.util.List;
import java.util.Random;

public class CleaningRobot implements CleanServiceable {
    private final Random RAND = new Random(5);

    private List<CleaningTool> cleaningTools; // = Arrays.asList(new Broom(), new VacuumCleaner(), new Swiffer());

    public CleaningRobot(List<CleaningTool> cleaningTools) {
        this.cleaningTools = cleaningTools;
    }

    @Override
    public void clean() {
        if (this.RAND.nextInt(2) == 0) {
            this.cleaningTools.get(this.RAND.nextInt(this.cleaningTools.size())).use();
        } else {
            for (CleaningTool tool : this.cleaningTools) {
                tool.use();
            }
        }
    }
}
