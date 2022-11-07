package io.kodlama.devs.service.concretes;

import io.kodlama.devs.data.abstracts.TechnologyRepository;
import io.kodlama.devs.entities.OtherTechnology;
import io.kodlama.devs.service.abstracts.TechnologyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyManager implements TechnologyService {

  private final TechnologyRepository repo;

  @Autowired
  public TechnologyManager(TechnologyRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<OtherTechnology> getAll() {
    return this.repo.findAll();
  }

  @Override
  public OtherTechnology add(OtherTechnology technology) {
    return this.repo.save(technology);
  }
}
