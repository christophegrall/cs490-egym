package com.cs490.egym.controllers;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs490.egym.models.User;
import com.cs490.egym.repositories.AuthorityRepository;
import com.cs490.egym.repositories.UserRepository;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthorityRepository authRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		//Respond with 409 (Conflict) if user already exists
		if(userRepo.findByUsername(user.getUsername()) != null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
		user.setAuthorities(Arrays.asList(authRepo.findOne(1))); //Sets user to ROLE_USER
		user.setEnabled(true); //Enables the user
		user.setLastPasswordResetDate(new Date(System.currentTimeMillis())); //Sets the date of account creation
		userRepo.save(user); //Inserts user into db
		return ResponseEntity.ok("success"); //returns OK status (code: 200)
	}
	
	//TODO: Add method to generate default exercises after creation of user
}
