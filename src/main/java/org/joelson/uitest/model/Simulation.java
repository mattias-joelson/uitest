package org.joelson.uitest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final String name;
    private final List<Garden> gardens;

    public Simulation(String name) {
        this.name = name;
        this.gardens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addGarden(Garden garden) {
        return gardens.add(garden);
    }

    public List<Garden> getGardens() {
        return Collections.unmodifiableList(gardens);
    }
}
