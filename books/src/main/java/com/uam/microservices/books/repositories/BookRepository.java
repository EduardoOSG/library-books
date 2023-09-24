package com.uam.microservices.books.repositories;

import com.uam.microservices.books.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    Set<BookEntity> findAllByAviableCopiesIsTrueAndActiveIsTrue();

    List<BookEntity> findAllBySectionIdAndActiveIsTrue(Long sectionId);

    List<BookEntity> findAllByAviableCopiesIsFalse();


}
