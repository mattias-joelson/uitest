package org.joelson.uitest.controller;

import org.joelson.uitest.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimulationController {

    @Autowired
    SimulationService simulationService;

    @GetMapping("/simulation")
    public String simulation(Model model) {
        model.addAttribute("simulation", simulationService.getSimulation());
        return "simulation";
    }
}
