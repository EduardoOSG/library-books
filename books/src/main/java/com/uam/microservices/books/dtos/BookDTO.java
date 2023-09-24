package com.uam.microservices.books.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private Long totalCopies;
    private Long availableCopies;
    private String codeSection;
    private String sectionGenre;

}
