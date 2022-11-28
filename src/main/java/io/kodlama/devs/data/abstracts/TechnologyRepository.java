package io.kodlama.devs.data.abstracts;

import io.kodlama.devs.entities.OtherTechnology;
import io.kodlama.devs.service.responses.GetAllTechsResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<OtherTechnology, Integer> {
  OtherTechnology findOtherTechnologyByTechnologyId(int id);
  OtherTechnology findOtherTechnologyByName(String name);

}
