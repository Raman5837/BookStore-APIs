package com.spring.Mockito.Controller;

import com.spring.Mockito.Entity.BookStore;
import com.spring.Mockito.Model.BookStoreDTO;
import com.spring.Mockito.Service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @RequestMapping(value = "/getAllBook")
    public List<BookStore> getAllBooks(){
        return bookStoreService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public void addBook(@RequestBody BookStoreDTO book){

        bookStoreService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteBook/{name}")
    public void deleteBook(@PathVariable String name){
        bookStoreService.deleteByName(name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateBookPrice/{id}")
    public void updateBookPrice(@PathVariable long id){

        bookStoreService.updateBookPrice(id);
    }
}
