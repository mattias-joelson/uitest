package org.joelson.uitest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garden {

    private final String name;
    private final List<Generator> generators;

    public Garden(String name) {
        this.name = name;
        this.generators = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addGenerator(Generator generator) {
        return generators.add(generator);
    }

    public List<Generator> getGenerators() {
        return Collections.unmodifiableList(generators);
    }
}
