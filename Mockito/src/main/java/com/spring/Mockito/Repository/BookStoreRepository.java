package com.spring.Mockito.Repository;

import com.spring.Mockito.Entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

    Optional<BookStore> findByTitle(String name);
    Optional<BookStore> findBookById(long id);
//    BookStore findById(long id);

}
