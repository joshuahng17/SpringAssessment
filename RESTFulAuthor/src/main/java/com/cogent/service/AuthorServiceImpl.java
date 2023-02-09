package com.cogent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.entity.Author;
import com.cogent.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository repo;
	
	@Override
	public void add(Author newAuthor) { //Create
		repo.save(newAuthor);
	}
	
	@Override
	public Optional<Author> get(int empId) { 
		return repo.findById(empId);
	}

	@Override
	public List<Author> getAll() { //Read
		return (List<Author>) repo.findAll();
	}

	@Override
	public Author update(Author author) { //Update
		return repo.save(author);
	}

	@Override
	public void delete(Author delAuthor) { //Delete
		repo.delete(delAuthor);
	}
	
	

}
