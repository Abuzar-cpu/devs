package io.kodlama.devs.data.abstracts;

import io.kodlama.devs.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
  Language findLanguageByName(String name);
}
