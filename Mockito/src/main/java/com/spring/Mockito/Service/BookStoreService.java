package com.spring.Mockito.Service;


import com.spring.Mockito.Entity.BookStore;
import com.spring.Mockito.Model.BookStoreDTO;
import com.spring.Mockito.Repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService implements BookStoreServiceInterface {

    @Autowired
    public BookStoreRepository  bookStoreRepository;



    @Override
    public List<BookStore> getAllBooks() {

        return new ArrayList<>(bookStoreRepository.findAll());
    }

    @Override
    public BookStore getBookById(long id) {

        return bookStoreRepository.findById(id).orElseThrow();
    }

    @Override
    public long addBook(BookStoreDTO book){

        try{
            BookStore newBook = new BookStore();
            newBook.setTitle(book.getTitle());
            newBook.setPrice(book.getPrice());
            newBook.setAuthor(book.getAuthor());

            bookStoreRepository.save(newBook);
            System.out.println("Book Added Successfully");

            return newBook.getId();
        }
        catch (Exception e){
            throw new DatabaseReadException("Unable To Add Book Because -> " + e.getMessage());
        }

    }


    @Override
    public void deleteByName(String name) {
        Optional<BookStore> bookStore = bookStoreRepository.findByTitle(name);
        bookStore.ifPresent(book -> bookStoreRepository.delete(book));
    }

    @Override
    public double updateBookPrice(long id) {

        try{
            BookStore book = bookStoreRepository.findBookById(id).orElseThrow();

            System.out.println("Book Name With Given Id Is : " + book.getTitle());

            if (book.getPrice() < 500) {
                book.setPrice(500.0);
                System.out.println("Price Updated Successfully. New Price Is " + book.getPrice());

            }
            else{

//                double oldPrice = book.getPrice();
//                book.setPrice(oldPrice);
                System.out.println("No Need To Update Price");
            }
            return book.getPrice();

        }
        catch (Exception e){
            throw new DatabaseReadException("Unable To Update Price Because -> " + e.getMessage());
        }

    }

}
