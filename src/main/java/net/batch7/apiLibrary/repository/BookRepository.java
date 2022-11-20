package net.batch7.apiLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.batch7.apiLibrary.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
