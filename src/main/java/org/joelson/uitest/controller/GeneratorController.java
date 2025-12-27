package org.joelson.uitest.controller;

import org.joelson.uitest.model.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneratorController {

    private Generator generator = null;

    @GetMapping("/generator")
    public String generator(Model model) {
        model.addAttribute("generator", this.generator = defaultGenerator());
        return "generator";
    }

    @PostMapping("/generator")
    public String updateGenerator(Model model, Generator that) {
        if (that == null) {
            System.out.println("that = null, defaulting");
            generator = defaultGenerator();
        } else if (!that.getName().equals(generator.getName()) || that.getCount() != generator.getCount()) {
            generator = that;
        }
        model.addAttribute("generator", generator);
        return "generator";
    }

    private static Generator defaultGenerator() {
        return new Generator("Default Name", 4711);
    }
}
