package com.cs490.egym.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs490.egym.beans.security.JwtTokenUtil;
import com.cs490.egym.models.ExerciseImpl;
import com.cs490.egym.models.User;
import com.cs490.egym.repositories.ExerciseRepository;
import com.cs490.egym.repositories.UserRepository;

@RestController
@RequestMapping("/api/exercise")
@PreAuthorize("hasRole('USER')")
public class AppController{
	@Value("${jwt.header}")
    private String tokenHeader;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ExerciseRepository repository;
	
	//MASTER
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Collection<ExerciseImpl>> listAllExercisesByUser(HttpServletRequest request) throws IOException
	{
		String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userRepo.findByUsername(username);
		return new ResponseEntity<>((Collection<ExerciseImpl>) repository.findAllByUser(user.getId()), HttpStatus.OK);
	}
	
	//TODO: DETAIL
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public ResponseEntity<ExerciseImpl> getById(@PathVariable("id") int id) throws IOException
	{
		/*return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);*/
		return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> addExercise(@RequestBody ExerciseImpl e)
	{
		ExerciseImpl createdExercise = null;
		try {
			createdExercise = repository.save(e);
		} catch(DataIntegrityViolationException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		} catch(Exception exc) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(createdExercise);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteExercise(@PathVariable("id") int id)
	{
			repository.delete(id);
	}
}
