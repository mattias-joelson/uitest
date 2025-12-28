package org.joelson.uitest.controller;

import org.joelson.uitest.model.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GeneratorController {

    private Generator generator = null;

    @GetMapping("/generator")
    public String generator(Model model) {
        model.addAttribute("generator", this.generator = defaultGenerator());
        createGeneratorList(model);
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
        createGeneratorList(model);
        return "generator";
    }

    private static Generator defaultGenerator() {
        return new Generator("Default Name", 4711);
    }

    private static void createGeneratorList(Model model) {
        List<Generator> list = List.of(new Generator("Foo", 1), new Generator("Bar", 2), new Generator("Buz", 3));
        model.addAttribute("genList", list);
        for (Generator generator : list) {
            model.addAttribute(generator.getName(), generator);
        }
    }
}
