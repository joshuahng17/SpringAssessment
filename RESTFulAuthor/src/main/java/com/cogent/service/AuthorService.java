package com.cogent.service;

import java.util.List;
import java.util.Optional;

import com.cogent.entity.Author;

public interface AuthorService {

	public void add(Author newAuthor); //Create
	public Optional<Author> get(int empId);
	public List<Author> getAll(); //Read
	public Author update(Author author); //Update
	public void delete(Author delAuthor); //Delete
}
