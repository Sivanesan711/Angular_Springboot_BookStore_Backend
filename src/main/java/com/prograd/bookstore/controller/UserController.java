package com.prograd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prograd.bookstore.dao.UserRepository;
import com.prograd.bookstore.model.User;

@Transactional

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/store")

public class UserController {
	
	@Autowired
    private UserRepository UserRepository;
	
	@GetMapping("/user")
    public List<User> getAllClasss() {
        return  (List<User>) UserRepository.findAll();
    }
	
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		UserRepository.save(user);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public User deleteUser(@PathVariable("id") long id) {
		User user = UserRepository.getOne(id);
		UserRepository.deleteById(id);
		return user;
	}

}
