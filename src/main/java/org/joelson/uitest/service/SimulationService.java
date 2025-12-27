package org.joelson.uitest.service;

import org.joelson.uitest.model.Garden;
import org.joelson.uitest.model.Generator;
import org.joelson.uitest.model.Simulation;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private final Simulation simulation;

    public SimulationService() {
        this.simulation = buildSimulation();
    }

    public Simulation getSimulation() {
        return simulation;
    }

    private static Simulation buildSimulation() {
        Simulation simulation = new Simulation("My Simulation");

        Garden firstGarden = new Garden("First Garden");
        firstGarden.addGenerator(new Generator("Gen 1-1", 3));
        firstGarden.addGenerator(new Generator("Gen 1-2", 74));
        firstGarden.addGenerator(new Generator("Gen 1-3", 23));
        simulation.addGarden(firstGarden);

        Garden secondGarden = new Garden("Second Garden");
        secondGarden.addGenerator(new Generator("Gen 2-1", 21));
        secondGarden.addGenerator(new Generator("Gen 2-2", 17));
        simulation.addGarden(secondGarden);

        return simulation;
    }
}
