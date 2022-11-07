package io.kodlama.devs.service.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {
  private String name;
  private List<GetAllLanguagesTechResponse> technologies;
}
