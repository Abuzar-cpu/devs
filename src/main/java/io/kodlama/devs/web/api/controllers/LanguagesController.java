package io.kodlama.devs.web.api.controllers;

import io.kodlama.devs.service.abstracts.LanguageService;
import io.kodlama.devs.service.requests.AddLanguageRequest;
import io.kodlama.devs.service.requests.UpdateLanguageById;
import io.kodlama.devs.service.responses.GetAllLanguagesResponse;
import io.kodlama.devs.service.responses.UpdateLanguageResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages/")
@Slf4j
public class LanguagesController {
  private final LanguageService languageService;

  @Autowired
  public LanguagesController(LanguageService service) {
    this.languageService = service;
  }

  @GetMapping("getall")
  public List<GetAllLanguagesResponse> getAll() {
    return this.languageService.getAll();
  }

  @PostMapping("add")
  public Boolean add(@RequestBody AddLanguageRequest language) {
    return this.languageService.add(language);
  }

  @DeleteMapping("delete")
  public void deleteLanguageByName(@RequestParam String name) {
    this.languageService.deleteLanguageByName(name);
  }

  @PatchMapping("updateById")
  public UpdateLanguageResponse updateLanguageById(@RequestBody UpdateLanguageById language) {
    return this.languageService.updateLanguageById(language);
  }
}
