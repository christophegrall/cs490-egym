package com.cs490.egym.controllers;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.repositories.ExerciseRepository;

@RestController
@RequestMapping(value = "/api/filter", method = RequestMethod.GET)
public class FilterController {
	@Autowired
	private ExerciseRepository repo;
	
	String decision = null;
	
	
	/**if(decision.equals("type")){
		filterType();
	}
	else if(decision.equals("difficulty")){
		filterDifficulty();
	}
	*/

	//@PreAuthorize("hasRole('USER')")
	@RequestMapping("/filterType")
	public void filterType() {
//		Repository.getDifficulty(diff);
		
		
//		String x = "blah";
//		if(x.equals(DifficultyEnum.ADVANCED)){
//			int[] s = repo.advanced("advanced");
//			
//		}
//		else if(x.equals(DifficultyEnum.BEGINNER)){
//			
//		}
//		else if(x.equals(DifficultyEnum.EXPERT)){
//			
//		}
//		else if(x.equals(DifficultyEnum.INTERMEDIATE)){
//			
//		}
	}
	
//	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/filterDifficulty")
	public void filterDifficulty(){
//		Repository.getType(type);
	}
	
}
