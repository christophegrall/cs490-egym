package com.cs490.egym.controllers;

import java.io.IOException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cs490.egym.models.ExerciseImpl;
import com.cs490.egym.repositories.ExerciseRepository;

@RestController
@RequestMapping("/api/exercise")
public class AppController{
	
	@Autowired
	private ExerciseRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Collection<ExerciseImpl>> listAllExercises() throws IOException
	{
		return new ResponseEntity<>((Collection<ExerciseImpl>) repository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public ResponseEntity<ExerciseImpl> getById(@PathVariable("id") int id) throws IOException
	{
		/*return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);*/
		return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ExerciseImpl addExercise(@RequestBody ExerciseImpl e)
	{
		return repository.save(e);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteExercise(@PathVariable("id") int id)
	{
			repository.delete(id);
	}
}
