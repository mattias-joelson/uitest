package org.joelson.uitest.controller;

import org.joelson.uitest.model.Garden;
import org.joelson.uitest.model.Generator;
import org.joelson.uitest.model.Simulation;
import org.joelson.uitest.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimulationController {

    public record Buy(String what, String arg) {
    }

    @Autowired
    SimulationService simulationService;

    private Simulation simulation;

    @GetMapping("/simulation")
    public String simulation(Model model) {
        simulation = simulationService.getSimulation();
        model.addAttribute("simulation", simulation);
        model.addAttribute("buy", new Buy("", ""));
        return "simulation";
    }

    @PostMapping("/simulation")
    public String postSimulation(Model model, Buy buy) {
        Map<String, Generator> generatorMap = new HashMap<>();
        for (Garden garden : simulation.getGardens()) {
            for (Generator generator : garden.getGenerators()) {
                generatorMap.put(generator.getName(), generator);
            }
        }
        Generator generator = generatorMap.get(buy.what());
        if (generator == null) {
            System.err.println("Can not buy \"" + buy.what + "\"");
            model.addAttribute("simulation", simulation);
            model.addAttribute("buy", new Buy("", ""));
            return "simulation";
        }

        int count = Integer.parseInt(buy.arg());
        generator.setCount(count);
        model.addAttribute("simulation", simulation);
        model.addAttribute("buy", new Buy("", ""));
        return "simulation";
    }

}
