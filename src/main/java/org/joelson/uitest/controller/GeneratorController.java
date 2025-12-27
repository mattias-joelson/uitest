package org.joelson.uitest.controller;

import org.joelson.uitest.model.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneratorController {

    @GetMapping("/generator")
    public String generator(Model model) {
        model.addAttribute("generator", defaultGenerator());
        return "generator";
    }

    private static Generator defaultGenerator() {
        return new Generator("Default Name", 4711);
    }
}
