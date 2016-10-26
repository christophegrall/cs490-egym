package com.cs490.egym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EgymApplication {
//	private static final Logger log = LoggerFactory.getLogger(EgymApplication.class);
	
//	@Autowired
//	private ExerciseRepository er;
	
	public static void main(String[] args) {
		SpringApplication.run(EgymApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo() {
//		return args -> {
////			Integer id = 1;
////			String name = "Bench press";
////			String desc = "You lift a weight over your chest.";
////			Exercise bp = new Exercise(name, desc, DifficultyEnum.INTERMEDIATE, TypeEnum.WEIGHTLIFTING, true);
////			Exercise run = new Exercise("Running", "You run on a treadmil", DifficultyEnum.ADVANCED, TypeEnum.CARDIO, false);
////			er.save(bp);
////			er.save(run);
////			System.out.println(er.findAll());
//		};
//	}
}
