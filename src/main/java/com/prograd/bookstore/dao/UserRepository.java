package com.prograd.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prograd.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
