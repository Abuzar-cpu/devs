package io.kodlama.devs.entities;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
public class Language {
    private int id = -1;
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public Language(int id, String name) {
        this.name = name;
        this.id = id;
    }
}
