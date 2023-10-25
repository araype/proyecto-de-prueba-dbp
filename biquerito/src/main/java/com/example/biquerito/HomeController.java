package com.example.biquerito;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "inicio";
    }

    @GetMapping("/registro")
    public String registro() {
        return "Registro";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
