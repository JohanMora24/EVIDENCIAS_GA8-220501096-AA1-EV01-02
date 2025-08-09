package com.kabodclientes.controller; // usa el paquete que tengas en tu proyecto

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/inicio.html";
    }
}
