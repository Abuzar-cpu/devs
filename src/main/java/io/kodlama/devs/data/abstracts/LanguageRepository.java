package io.kodlama.devs.data.abstracts;

import io.kodlama.devs.entities.Language;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language addLanguage(Language language);

    Language getByName(String name);

    Language getById(int id);

    Language deleteLanguageByName(@RequestParam String name);

    Language deleteLanguageById(@RequestParam int id);

    Boolean updateLanguage(Language language);
}
