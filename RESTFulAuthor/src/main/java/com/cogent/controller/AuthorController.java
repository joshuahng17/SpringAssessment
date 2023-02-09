package com.cogent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.entity.AuthRequest;
import com.cogent.entity.Author;
import com.cogent.service.AuthorServiceImpl;
import com.cogent.util.JwtUtil;

@RestController
public class AuthorController {

	@Autowired
	private AuthorServiceImpl serv;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/authors") //Returns every entry in authors
	public List<Author> read(){
		return serv.getAll();
	}
	
	@PostMapping("/authors") //Adds an entry to authors, with a confirmation message
	public String create(@Validated @RequestBody Author newAuthor) {
		serv.add(newAuthor);
		return "Added Author "+newAuthor.getAuthorName()+" successfully";
	}
	
	@PutMapping("/authors") //Updates an entry in authors, then shows the updated entry
	public Author update(@Validated @RequestBody Author author) {
		return serv.update(author);
	}
	
	@DeleteMapping("/authors") //Deletes an entry in authors, with a confirmation message
	public String delete(@RequestParam(value = "id") Integer authorId) {
		Optional<Author> author = serv.get(authorId);
		serv.delete(author.get());
		return "Author Id "+authorId+" deleted successfully";
	}
	
	@PostMapping("/authenticate") //Converts a valid username and password into an authentication token for later http requests
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
			);
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
