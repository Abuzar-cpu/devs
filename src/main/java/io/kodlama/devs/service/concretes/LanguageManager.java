package io.kodlama.devs.service.concretes;

import io.kodlama.devs.data.abstracts.LanguageRepository;
import io.kodlama.devs.data.abstracts.TechnologyRepository;
import io.kodlama.devs.entities.Language;
import io.kodlama.devs.entities.OtherTechnology;
import io.kodlama.devs.service.abstracts.LanguageService;
import io.kodlama.devs.service.requests.AddLanguageRequest;
import io.kodlama.devs.service.requests.UpdateLanguageById;
import io.kodlama.devs.service.requests.UpdateLanguageTechRequest;
import io.kodlama.devs.service.responses.GetAllLanguagesResponse;
import io.kodlama.devs.service.responses.GetAllLanguagesTechResponse;
import io.kodlama.devs.service.responses.UpdateLanguageResponse;
import io.kodlama.devs.service.responses.UpdateLanguageTechResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LanguageManager implements LanguageService {
  private final LanguageRepository repository;
  private final TechnologyRepository techRepo;

  @Autowired
  public LanguageManager(LanguageRepository repo, TechnologyRepository techRepo) {
    this.repository = repo;
    this.techRepo = techRepo;
  }

  @Override
  public List<GetAllLanguagesResponse> getAll() {
    List<GetAllLanguagesResponse> result = new ArrayList<>();
    List<Language> languages =
        this.repository.findAll().stream().filter(language -> language.getStatus() == 1)
            .toList();

    for (Language language : languages) {
      result.add(new GetAllLanguagesResponse(language.getName(), language.getTechnologies().stream()
          .map(tech -> new GetAllLanguagesTechResponse(tech.getName())).toList()));
    }

    return result;
  }

  @Override
  public Boolean add(AddLanguageRequest language) {
    var exists = this.repository.findLanguageByName(language.getName());
    if (exists != null) {
      log.warn("Language " + exists.getName() + " already exists");
      return false;
    }
    Language lang = new Language();
    lang.setName(language.getName());
    lang.setTechnologies(language.getTechnologies().stream()
        .map(tech -> new OtherTechnology(0, tech.getName(), null)).toList());
    this.repository.save(lang);
    return true;
  }

  @Override
  public void deleteLanguageByName(String name) {
    Language language = this.repository.findLanguageByName(name);
    if (language != null) {
      language.setStatus(0);
      this.repository.save(language);

      for (var tech : language.getTechnologies()) {
        tech.setStatus(0);
        this.techRepo.save(tech);

        log.info(
            "Technology " + tech.getName() + " deleted successfully; associated with language " +
                language.getName());
      }
      log.info(name + " deleted successfully");
    } else {
      log.warn(name + " does not exists");
    }
  }

  @Override
  public UpdateLanguageResponse updateLanguageById(UpdateLanguageById language) {
    int id = language.getId();
    Language lang = this.repository.findLanguageById(id);
    if (lang == null) {
      log.error("Language " + language.getName() + " does not exists");
      return null;
    }
    List<OtherTechnology> technologies = new ArrayList<>();
    for (UpdateLanguageTechRequest tech : language.getTechnologies()) {
      OtherTechnology technology = this.techRepo.findOtherTechnologyByName(tech.getName());
      if (technology != null) {
        technologies.add(technology);
      }
    }
    lang.setName(language.getName());
    lang.setTechnologies(technologies);
    lang.setStatus(1);
    this.repository.save(lang);
    return new UpdateLanguageResponse(lang.getName(),
        lang.getTechnologies().stream().map(tech -> new UpdateLanguageTechResponse(tech.getName()))
            .toList());
  }
}
