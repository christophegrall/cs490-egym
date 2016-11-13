package com.cs490.egym.controllers;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.models.ExerciseImpl;
import com.cs490.egym.repositories.ExerciseRepository;

@RestController
@RequestMapping(value = "/api/filter", method = RequestMethod.GET)
public class FilterController {
	@Autowired
	private ExerciseRepository repo;
	
	String decision = null;
	

	

	//@PreAuthorize("hasRole('USER')")
	@RequestMapping("/filterType")
	public void filterType() {
		
		String diff = "WEIGHTLIFTING";
		
		List<ExerciseImpl> diffList = repo.getDifficulty(diff);
		
		System.out.println(diffList.toArray().toString());
	}
	
//	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/filterDifficulty")
	public void filterDifficulty(){
		
		String type = "INTERMEDIATE";
		
		List<ExerciseImpl> typeList = repo.getType(type);
		
		System.out.println(typeList.toArray().toString());
	}
	
}
