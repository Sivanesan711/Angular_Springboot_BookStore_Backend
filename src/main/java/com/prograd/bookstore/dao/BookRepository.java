package com.prograd.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prograd.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
