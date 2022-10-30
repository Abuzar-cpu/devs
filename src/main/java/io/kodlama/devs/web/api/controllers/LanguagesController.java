package io.kodlama.devs.web.api.controllers;

import io.kodlama.devs.entities.Language;
import io.kodlama.devs.service.abstracts.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService service) {
        this.languageService = service;
    }

    @GetMapping("getall")
    public List<Language> getAll() {
        return this.languageService.getAll();
    }

    @PostMapping("add")
    public Language addLanguage(@RequestBody Language language) {
        return this.languageService.addLanguage(language);
    }

    @GetMapping("getbyid/{id}")
    public Language getById(@PathVariable int id) {
        return this.languageService.getById(id);
    }

    @GetMapping("getbyname")
    public Language getByName(@RequestParam String name) {
        return this.languageService.getByName(name);
    }
}
