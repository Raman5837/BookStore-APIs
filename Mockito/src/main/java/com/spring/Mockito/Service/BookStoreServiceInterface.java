package com.spring.Mockito.Service;

import com.spring.Mockito.Entity.BookStore;
import com.spring.Mockito.Model.BookStoreDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public interface BookStoreServiceInterface {

    void deleteByName(String name);
    long addBook(BookStoreDTO book);
    double updateBookPrice(long id);
    List<BookStore> getAllBooks();
    BookStore getBookById(long id);
}
