package io.kodlama.devs.service.concretes;

import io.kodlama.devs.data.abstracts.LanguageRepository;
import io.kodlama.devs.entities.Language;
import io.kodlama.devs.entities.OtherTechnology;
import io.kodlama.devs.service.abstracts.LanguageService;
import io.kodlama.devs.service.requests.AddLanguageRequest;
import io.kodlama.devs.service.responses.GetAllLanguagesResponse;
import io.kodlama.devs.service.responses.GetAllLanguagesTechResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LanguageManager implements LanguageService {
  private final LanguageRepository repository;

  @Autowired
  public LanguageManager(LanguageRepository repo) {
    this.repository = repo;
  }

  @Override
  public List<GetAllLanguagesResponse> getAll() {
    List<GetAllLanguagesResponse> result = new ArrayList<>();
    List<Language> languages = this.repository.findAll().stream().filter(language -> language.getStatus() == 1)
        .toList();

    for(Language language : languages) {
      result.add(new GetAllLanguagesResponse(language.getName(), language.getTechnologies().stream().map(tech -> new GetAllLanguagesTechResponse(tech.getName())).toList()));
    }

    return result;
  }

  @Override
  public Boolean add(AddLanguageRequest language) {
    Language lang = new Language();
    lang.setName(language.getName());
    lang.setTechnologies(language.getTechnologies().stream().map(tech -> new OtherTechnology(0, tech.getName(), null)).toList());
    this.repository.save(lang);
    return true;
  }

  @Override
  public void deleteLanguageByName(String name) {
    Language language = this.repository.findLanguageByName(name);
    if(language != null) {
      language.setStatus(0);
      this.repository.save(language);
    }
  }

  @Override
  public Language updateLanguage(Language language) {
    Language newLang = this.repository.findLanguageByName(language.getName());
    newLang.setName(language.getName());
    newLang.setTechnologies(language.getTechnologies());
    newLang.setStatus(1);
    return this.repository.save(newLang);
  }
}
