package com.cogent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
