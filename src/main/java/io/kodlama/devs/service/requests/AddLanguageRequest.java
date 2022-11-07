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
public class AddLanguageRequest {
  private String name;
  private List<AddLanguageTechRequest> technologies;
}
