package io.kodlama.devs.web.api.controllers;

import io.kodlama.devs.service.abstracts.TechnologyService;
import io.kodlama.devs.service.responses.GetAllTechsResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/techs/")
public class TechnologiesController {
  private final TechnologyService service;

  @Autowired
  public TechnologiesController(TechnologyService service) {
    this.service = service;
  }

  @GetMapping("getall")
  public List<GetAllTechsResponse> getAll() {
    return this.service.getAll();
  }

}
