package com.spring.Mockito.Entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bookstore")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;


    @Column(name = "price")
    private double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookStore bookStore = (BookStore) o;
        return Objects.equals(id, bookStore.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
