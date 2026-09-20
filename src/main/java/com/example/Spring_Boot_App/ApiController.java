package com.example.Spring_Boot_App;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/thema")
    public String getThema() {
        return "Aufbau und Erweiterung einer CI/CD-Pipeline für ein Softwareprojekt";
    }

    @GetMapping("/mitglieder")
    public List<String> getMitglieder() {
        // Trage hier eure echten Namen ein
        return Arrays.asList("Mitglied 1", "Mitglied 2", "Mitglied 3", "Mitglied 4");
    }
    
    @GetMapping("/abgabedatum")
    public String getAbgabeDatum() {
        return "AbgabeDatum ist der 24.10.2028";
    }
}