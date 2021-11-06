package be.jochenhansoul.cleaninghouse.service;

import be.jochenhansoul.cleaninghouse.service.tool.Broom;
import be.jochenhansoul.cleaninghouse.service.tool.Swiffer;
import be.jochenhansoul.cleaninghouse.service.tool.Usable;
import be.jochenhansoul.cleaninghouse.service.tool.VacuumCleaner;

import java.util.Arrays;
import java.util.List;

public class CleaningRobot {
    private List<Usable> cleaningTools = Arrays.asList(new Broom(), new VacuumCleaner(), new Swiffer());
}
