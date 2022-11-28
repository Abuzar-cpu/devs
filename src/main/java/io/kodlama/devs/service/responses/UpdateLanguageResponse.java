package io.kodlama.devs.service.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageResponse {
  private String name;
  private List<UpdateLanguageTechResponse> technologies;
}
