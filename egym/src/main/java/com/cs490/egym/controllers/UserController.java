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

import com.cs490.egym.enums.WeightTypeEnum;
import com.cs490.egym.models.CardioImpl;
import com.cs490.egym.models.CoreImpl;
import com.cs490.egym.models.User;
import com.cs490.egym.models.WeightliftingImpl;
import com.cs490.egym.repositories.AuthorityRepository;
import com.cs490.egym.repositories.CardioRepository;
import com.cs490.egym.repositories.CoreRepository;
import com.cs490.egym.repositories.ExerciseRepository;
import com.cs490.egym.repositories.UserRepository;
import com.cs490.egym.repositories.WeightliftingRepository;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private ExerciseRepository exerciseRepo;
	
	@Autowired
	private CardioRepository cardioRepo;
	
	@Autowired
	private CoreRepository coreRepo;
	
	@Autowired
	private WeightliftingRepository wlRepo;
	
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
		User createdUser = userRepo.save(user); //Inserts user into db
		createDefaultExercises(createdUser);
		return ResponseEntity.ok("success"); //returns OK status (code: 200)
	}
	
	private void createDefaultExercises(User user) {
		//Example of user created exercise
//		ExerciseImpl eliptical = new ExerciseImpl("Eliptical", "Eliptical", DifficultyEnum.BEGINNER, TypeEnum.CARDIO, user.getId());
//		exerciseRepo.save(eliptical);
		
		WeightliftingImpl benchWL = new WeightliftingImpl(0, WeightTypeEnum.LBS, Integer.valueOf(0), Integer.valueOf(0), exerciseRepo.findByName("Bench press"), user, new Date(System.currentTimeMillis()));
		
		CardioImpl runningCardio = new CardioImpl(0, Integer.valueOf(0), exerciseRepo.findByName("Running"), user, new Date(System.currentTimeMillis()));
		
		CoreImpl sitUpsCore = new CoreImpl(exerciseRepo.findByName("Sit-ups"), user, new Date(System.currentTimeMillis()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
		
		wlRepo.save(benchWL);
		coreRepo.save(sitUpsCore);
		cardioRepo.save(runningCardio);
	}
}
