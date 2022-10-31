package io.kodlama.devs.data.concretes;

import io.kodlama.devs.data.abstracts.LanguageRepository;
import io.kodlama.devs.entities.Language;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class InMemoryLanguageRepo implements LanguageRepository {
    private final List<Language> languages = new ArrayList<>();

    private static int lastId = 2;

    public InMemoryLanguageRepo() {
        languages.add(new Language(0, "C"));
        languages.add(new Language(1, "Java"));
    }

    @Override
    public List<Language> getAll() {
        return this.languages.stream().filter(lang -> lang.getStatus() == 1).collect(Collectors.toList());
    }

    @Override
    public Language addLanguage(Language language) {
        if(this.getByName(language.getName()) != null) {
            return new Language(language.getName() + " already exists");
        }

        language.setId(lastId++);
        this.languages.add(language);

        return language;
    }

    @Override
    public Language getById(int id) {
        for (Language lang : this.languages) {
            if(lang.getId() == id && lang.getStatus() == 1)
                return lang;
        }

        return null;
    }

    @Override
    public Language deleteLanguageByName(String name) {
        Language language = null;
        for(Language lang : this.languages) {
            if(lang.getName().equalsIgnoreCase(name)) {
                lang.setStatus(0);
                language = lang;
            }
        }

        return language;
    }

    @Override
    public Language deleteLanguageById(int id) {
        Language language = null;
        for(Language lang : this.languages) {
            if(lang.getId() == id) {
                lang.setStatus(0);
                language = lang;
            }
        }

        return language;
    }

    @Override
    public Language getByName(String name) {
        log.info("Searching for: " + name);
        for (Language lang : this.languages) {
            if(lang.getName().equalsIgnoreCase(name) && lang.getStatus() == 1)
                return lang;
        }

        return null;
    }

    @Override
    public Boolean updateLanguage(Language language) {
        if(language.getId() >= this.languages.size())
            return false;
        Language languageToUpdate = this.languages.get(language.getId());
        if(languageToUpdate.getStatus() == 0)
            return false;

        languageToUpdate.setName(language.getName());
        //language.setStatus(language.getStatus());

        return true;
    }
}
