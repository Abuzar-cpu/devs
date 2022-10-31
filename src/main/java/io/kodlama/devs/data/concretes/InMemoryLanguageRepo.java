package io.kodlama.devs.data.concretes;

import io.kodlama.devs.data.abstracts.LanguageRepository;
import io.kodlama.devs.entities.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepo implements LanguageRepository {
    private final List<Language> languages = new ArrayList<>();

    private static int lastId = 2;

    public InMemoryLanguageRepo() {
        languages.add(new Language(0, "C#"));
        languages.add(new Language(1, "Java"));
    }

    public List<Language> getAll() {
        return this.languages;
    }

    public Language addLanguage(Language language) {
        if(this.getByName(language.getName()) != null) {
            return new Language(language.getName() + " already exists");
        }

        language.setId(lastId++);
        this.languages.add(language);

        return language;
    }

    public Language getById(int id) {
        for (Language lang : this.languages) {
            if(lang.getId() == id)
                return lang;
        }

        return null;
    }

    public Language getByName(String name) {
        for (Language lang : this.languages) {
            if(lang.getName().equalsIgnoreCase(name))
                return lang;
        }

        return null;
    }
}
