package com.pidev.backend.controller;

import com.pidev.backend.entity.Glossary;
import com.pidev.backend.service.GlossaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin" )

@RestController
@AllArgsConstructor
@RequestMapping("/glossary")
public class GlossaryController {
    private final  GlossaryService glossaryService;

    @GetMapping("/get_all")
    public List<Glossary> getAllTermes() {
        return glossaryService.getAllTermes();
    }
    @PostMapping("/add")
    public Glossary addGlossary(@RequestBody Glossary glossary) {
        return glossaryService.addGlossary(glossary);
    }

    @PutMapping("/update/{id}")
    public Glossary updateGlossary(@PathVariable String id, @RequestBody Glossary glossary) {
        return glossaryService.updateGlossary(id, glossary);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGlossary(@PathVariable String id) {
        glossaryService.deleteGlossary(id);
        return ResponseEntity.ok().build();
    }

}
