package io.kodlama.devs.service.concretes;

import io.kodlama.devs.data.abstracts.LanguageRepository;
import io.kodlama.devs.entities.Language;
import io.kodlama.devs.service.abstracts.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageRepository repository;

    @Autowired
    public LanguageManager(LanguageRepository repo) {
        this.repository = repo;
    }
    public List<Language> getAll() {
        return this.repository.getAll();
    }

    public Language addLanguage(Language language) {
        if(!language.getName().equalsIgnoreCase("")) {
            return this.repository.addLanguage(language);
        }

        return null;
    }

    public Language getById(int id) {
        return this.repository.getById(id);
    }

    public Language getByName(String name){
        return this.repository.getByName(name);
    }
}
