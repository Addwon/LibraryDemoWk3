package me.afua.librarydemo;

import org.springframework.data.repository.CrudRepository;

public interface BorrowingHistoryRepo extends CrudRepository<BorrowingHistory,Long> {
    Iterable <BorrowingHistory> findAllByABook(Book id);
}
