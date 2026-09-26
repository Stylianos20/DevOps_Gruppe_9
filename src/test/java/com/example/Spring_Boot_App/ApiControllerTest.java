package com.example.Spring_Boot_App;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetThema() throws Exception {
        // Testet den Endpunkt /api/thema
        mockMvc.perform(get("/api/thema"))
               .andExpect(status().isOk())
               .andExpect(content().string("Aufbau und Erweiterung einer CI/CD-Pipeline für ein Softwareprojekt."));
    }

    @Test
    public void testGetMitglieder() throws Exception {
        // Testet den Endpunkt /api/mitglieder und prüft, ob 4 Mitglieder zurückgegeben werden
        mockMvc.perform(get("/api/mitglieder"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(3)))
               .andExpect(jsonPath("$[0]").value("Mahmut"));
    }

    @Test
    public void testGetAbgabeDatum() throws Exception {
        // Testet den Endpunkt /api/abgabedatum x
        mockMvc.perform(get("/api/abgabedatum"))
               .andExpect(status().isOk())
               .andExpect(content().string("AbgabeDatum ist der 28.09.2026"));
    }
}