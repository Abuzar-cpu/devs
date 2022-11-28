package io.kodlama.devs.service.abstracts;

import io.kodlama.devs.service.requests.AddLanguageRequest;
import io.kodlama.devs.service.requests.UpdateLanguageById;
import io.kodlama.devs.service.responses.GetAllLanguagesResponse;
import io.kodlama.devs.service.responses.UpdateLanguageResponse;
import java.util.List;

public interface LanguageService {
  List<GetAllLanguagesResponse> getAll();

  Boolean add(AddLanguageRequest language);

  void deleteLanguageByName(String name);

  UpdateLanguageResponse updateLanguageById(UpdateLanguageById language);
}
