package com.cs490.egym.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.enums.TypeEnum;
import com.cs490.egym.enums.WeightTypeEnum;
import com.cs490.egym.models.CardioImpl;
import com.cs490.egym.models.CoreImpl;
import com.cs490.egym.models.ExerciseImpl;
import com.cs490.egym.models.User;
import com.cs490.egym.models.WeightliftingImpl;
import com.cs490.egym.repositories.CardioRepository;
import com.cs490.egym.repositories.CoreRepository;
import com.cs490.egym.repositories.ExerciseRepository;
import com.cs490.egym.repositories.UserRepository;
import com.cs490.egym.repositories.WeightliftingRepository;

@Component
public class StartupDBInserts implements CommandLineRunner {
	@Autowired
	private CardioRepository cardioRepo;
	
	@Autowired
	private CoreRepository coreRepo;
	
	@Autowired
	private ExerciseRepository exerciseRepo;
	
	@Autowired
	private WeightliftingRepository wlRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... arg0) throws Exception {
		User user = userRepo.findByUsername("user");
		List<ExerciseImpl> exList = new ArrayList<ExerciseImpl>();
		
		ExerciseImpl bench = new ExerciseImpl("Bench press", "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position.", DifficultyEnum.INTERMEDIATE, TypeEnum.WEIGHTLIFTING);
		WeightliftingImpl benchWL = new WeightliftingImpl(225.0, WeightTypeEnum.LBS, Integer.valueOf(5), Integer.valueOf(5), bench, user, new Date(System.currentTimeMillis()));
		
		ExerciseImpl running = new ExerciseImpl("Running", "Running is a method of terrestrial locomotion allowing humans and other animals to move rapidly on foot.", DifficultyEnum.BEGINNER, TypeEnum.CARDIO);
		CardioImpl runningCardio = new CardioImpl(2.0, Integer.valueOf(10), running, user, new Date(System.currentTimeMillis()));
		
		ExerciseImpl sitUps = new ExerciseImpl("Sit-ups", "The sit-up (or curl-up) is an abdominal endurance training exercise commonly performed to strengthen and tone the abdominal muscles.", DifficultyEnum.BEGINNER, TypeEnum.CORE);
		CoreImpl sitUpsCore = new CoreImpl(sitUps, user, new Date(System.currentTimeMillis()), Integer.valueOf(10), Integer.valueOf(10), Integer.valueOf(10));
		
		exList.add(bench);
		exList.add(running);
		exList.add(sitUps);
		
		exerciseRepo.save(exList);
		wlRepo.save(benchWL);
		coreRepo.save(sitUpsCore);
		cardioRepo.save(runningCardio);
	}
	
}
