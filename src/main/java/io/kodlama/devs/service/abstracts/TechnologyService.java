package io.kodlama.devs.service.abstracts;

import io.kodlama.devs.entities.OtherTechnology;
import io.kodlama.devs.service.responses.GetAllTechsResponse;
import java.util.List;


public interface TechnologyService {
  List<GetAllTechsResponse> getAll();

  OtherTechnology add(OtherTechnology technology);

  OtherTechnology findTechnologyByName(String name);
}
