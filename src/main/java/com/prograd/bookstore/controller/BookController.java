package com.prograd.bookstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prograd.bookstore.dao.BookRepository;
import com.prograd.bookstore.model.Book;

@Transactional

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/book")

public class BookController {
	
	private byte[] bytes;
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/get")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/add")
	public void createBook(@RequestBody Book book) throws IOException {
		book.setPicByte(this.bytes);
		bookRepository.save(book);
		this.bytes = null;
	}
	
	@PutMapping("/update")
	public void updateBook(@RequestBody Book book) {
		bookRepository.save(book);
	}

	@DeleteMapping(path = { "/{id}" })
	public Book deleteBook(@PathVariable("id") long id) {
		Book book = bookRepository.getOne(id);
		bookRepository.deleteById(id);
		return book;
	}


}
