package com.spring.Mockito.Service;

import com.spring.Mockito.Entity.BookStore;
import com.spring.Mockito.Model.BookStoreDTO;
import com.spring.Mockito.Repository.BookStoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BookStoreServiceTest {

    @InjectMocks
    @Autowired
    private BookStoreService bookStoreService;

//    @Mock
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Test
    void addBook() {

        BookStoreDTO book = new BookStoreDTO();
        book.setAuthor("Aman");
        book.setTitle("Python");
        book.setPrice(600.0);

        BookStore newBook = bookStoreService.getBookById(7);

        assertEquals(7, newBook.getId());
    }

    @Test
    void getAllBooks() {

//        List<BookStore> bookList = bookStoreRepository.findAll();
        List<BookStore> bookList = bookStoreService.getAllBooks();

        assertEquals(20, bookList.size());

    }


    @Test
    void deleteByName() {

        BookStore bookToBeDeleted = bookStoreRepository.findByTitle("Python").orElseThrow();
        bookStoreService.deleteByName(bookToBeDeleted.getTitle());

        BookStore expectedResult = null;
        Optional<BookStore> actualResult = bookStoreRepository.findByTitle("Python");

        if(actualResult.isPresent()){
            expectedResult = actualResult.get();
        }

        assertThat(expectedResult).isNull();

    }

    @Test
    void getBookById(){

        BookStore book = bookStoreService.getBookById(1);
        assertThat(book.getId()).isEqualTo(1);
        assertEquals("React", bookStoreService.getBookById(1).getTitle());
    }

    @Test
    void updateBookPrice() {

//        BookStoreDTO book = new BookStoreDTO();
        BookStore book = new BookStore();
        book.setId(10);
        book.setAuthor("A");
        book.setTitle("B");
        book.setPrice(300);

//        bookStoreService.addBook(book);

        assertEquals(500, bookStoreService.updateBookPrice(10));

//        assertThrows(DatabaseReadException.class, () -> bookStoreService.updateBookPrice(book.getId()));
    }
}