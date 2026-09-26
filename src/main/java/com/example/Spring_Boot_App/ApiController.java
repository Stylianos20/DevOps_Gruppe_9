package com.example.Spring_Boot_App;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/thema")
    public String getThema() {
        return "Aufbau und Erweiterung einer CI/CD-Pipeline für ein Softwareprojekt.";
    }

    @GetMapping("/mitglieder")
    public List<String> getMitglieder() {
        // Trage hier eure echten Namen ein
        return Arrays.asList("Mahmut", "Yasmina", "Styli");
    }
    
    @GetMapping("/abgabedatum")
    public String getAbgabeDatum() {
        return "AbgabeDatum ist der 28.09.2026";
    }

    @GetMapping("/test-security")
    public String testSecurity(@RequestParam("input") String input) {
    // Dies provoziert oft eine CodeQL-Warnung (Log Forging / Unchecked Input)
    System.out.println("Benutzereingabe: " + input); 
    return "Test: " + input;
}
}