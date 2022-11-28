package io.kodlama.devs.service.requests;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageById {
  private int id;
  private String name;
  private List<UpdateLanguageTechRequest> technologies;
}
