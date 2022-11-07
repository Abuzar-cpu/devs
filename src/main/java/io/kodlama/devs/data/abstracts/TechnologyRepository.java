package io.kodlama.devs.data.abstracts;

import io.kodlama.devs.entities.OtherTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<OtherTechnology, Integer> {
}
