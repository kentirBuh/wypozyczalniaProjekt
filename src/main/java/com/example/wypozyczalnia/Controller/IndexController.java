package com.example.wypozyczalnia.Controller;

import com.example.wypozyczalnia.Model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    @PostMapping("/")
    public String Redirect() {
        return "redirect:/funkcje.html";
    }

}
