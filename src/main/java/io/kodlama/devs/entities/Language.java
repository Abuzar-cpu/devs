package io.kodlama.devs.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "languages")
public class Language {

  @Id
  @Column(name = "language_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private int status = 1;

  @OneToMany(
      cascade = CascadeType.ALL
  )
  @JoinColumn(name = "language_id", nullable = false)
  public List<OtherTechnology> technologies;

  @Override
  public String toString() {
    return "Language{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", status=" + status +
        ", technologies=" + technologies +
        '}';
  }
}
