package com.spring.Mockito.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class BookStoreDTO {

    private long id;
    
    private String title;
    
    private String author;
    
    private double price;
}
