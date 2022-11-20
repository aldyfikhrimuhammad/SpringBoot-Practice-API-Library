package net.batch7.apiLibrary.repository;

import net.batch7.apiLibrary.model.entity.Book;
import net.batch7.apiLibrary.model.entity.Borrow;
import net.batch7.apiLibrary.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Optional<Borrow> findByUser(User user);
    Optional<Borrow> findByBook(Book book);
}
