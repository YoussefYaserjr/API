package com.codewithmosh.store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Youssef");
        return "index";
    }
    /*@RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("name", "Youssef");
        return "index";
    }*/
}
