package be.jochenhansoul.cleaninghouse.service;

import be.jochenhansoul.cleaninghouse.service.tool.*;

import java.util.Arrays;
import java.util.List;

public class CleaningRobot {
    private List<CleaningTool> cleaningTools = Arrays.asList(new Broom(), new VacuumCleaner(), new Swiffer());
}
