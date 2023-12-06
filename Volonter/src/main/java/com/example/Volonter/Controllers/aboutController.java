package com.example.Volonter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class aboutController {
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Hi about");
        return "aboutMain";
    }
}
