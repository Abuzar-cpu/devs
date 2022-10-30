package io.kodlama.devs.data.abstracts;

import io.kodlama.devs.entities.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language addLanguage(Language language);

    Language getByName(String name);
    Language getById(int id);
}
