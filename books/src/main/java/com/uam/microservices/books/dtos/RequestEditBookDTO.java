package com.uam.microservices.books.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestEditBookDTO {

    private Long id;
    private String title;
    private String genre;
    private String author;
    private Long totalCopies;

}
