package com.example.biquerito;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomepage() {
        return "inicio";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @GetMapping("/prehome")
    public String prehome() {
        return "prehome";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
