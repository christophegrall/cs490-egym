package com.cs490.egym.controllers;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.models.ExerciseImpl;
import com.cs490.egym.repositories.ExerciseRepository;

@RestController
@RequestMapping(value = "/api/filter", method = RequestMethod.GET)
public class FilterController {
	@Autowired
	private ExerciseRepository repo;
	
	

	

	//@PreAuthorize("hasRole('USER')")
	@RequestMapping("/type")
	public List<ExerciseImpl> filterType(@RequestParam("type") String type) {
		
//	String type = "CORE";
		
		List<ExerciseImpl> typeList = repo.getType(type);
		
//		System.out.println(diffList.toArray().toString());
		return typeList;
	}
	
//	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/difficulty")
	public List<ExerciseImpl> filterDifficulty(@RequestParam("diff") String diff){
		
//		String diff = "INTERMEDIATE";
		
		List<ExerciseImpl> diffList = repo.getDifficulty(diff);
		
		return diffList;
		
//		System.out.println(diffList.toArray().toString());
	}
	
}
