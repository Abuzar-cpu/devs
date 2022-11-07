package io.kodlama.devs.service.abstracts;

import io.kodlama.devs.entities.Language;
import io.kodlama.devs.service.requests.AddLanguageRequest;
import io.kodlama.devs.service.responses.GetAllLanguagesResponse;
import java.util.List;

public interface LanguageService {
  List<GetAllLanguagesResponse> getAll();

  Boolean add(AddLanguageRequest language);
  void deleteLanguageByName(String name);
  Language updateLanguage(Language language);
}
