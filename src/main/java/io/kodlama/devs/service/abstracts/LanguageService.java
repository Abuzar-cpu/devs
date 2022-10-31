package io.kodlama.devs.service.abstracts;

import io.kodlama.devs.entities.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    Language addLanguage(Language language);

    Language getById(int id);

    Language getByName(String name);

    Language deleteLanguageByName(String name);

    Language deleteLanguageById(int id);

    Boolean updateLanguage(Language language);
}
