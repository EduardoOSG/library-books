package com.uam.microservices.books.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book", schema = "public")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, length = 50)
    private String genre;

    @Column(nullable = false)
    private Long totalCopies;

    @Column(nullable = false)
    private Long numberCopies;

    @Column(nullable = false)
    private Long sectionId;

    @Column(nullable = false)
    private Boolean aviableCopies;

    @Column
    private Boolean active;
}
