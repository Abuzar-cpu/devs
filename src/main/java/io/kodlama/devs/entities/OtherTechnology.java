package io.kodlama.devs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technologies")
public class OtherTechnology {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int technologyId;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private int status;

  @ManyToOne()
  @JsonIgnore
  private Language language;

  public OtherTechnology(int technologyId, String name, Language language) {
    this.technologyId = technologyId;
    this.name = name;
    this.language = language;
    this.status = 1;
  }
}
