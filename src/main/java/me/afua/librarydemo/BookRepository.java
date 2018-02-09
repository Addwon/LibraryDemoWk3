package me.afua.librarydemo;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
    Iterable<Book> findAllByBorrowed(boolean checkBorrowed);
    Iterable<Book> findAllByOrderByBorrowedtimesDesc();
}
