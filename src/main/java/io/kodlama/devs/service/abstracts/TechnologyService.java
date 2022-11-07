package io.kodlama.devs.service.abstracts;

import io.kodlama.devs.entities.OtherTechnology;
import java.util.List;


public interface TechnologyService {
  List<OtherTechnology> getAll();
  OtherTechnology add(OtherTechnology technology);
}
