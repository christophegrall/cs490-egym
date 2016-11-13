package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs490.egym.models.ExerciseImpl;

public interface ExerciseRepository extends JpaRepository<ExerciseImpl, Integer> {
//	@Query(value="Select... ?1", nativeQuery=true)
//	int[] advanced(String a);
//	@Query(value="Select....", nativeQuery=true)
//	int[] beginner(String b);
//	@Query(value="Select....", nativeQuery=true)
//	int[] intermediate(String i);
//	@Query(value="Select...", nativeQuery=true)
//	int[] expert(String e);
	@Query(value = "select * from exercise where difficulty = ?1", nativeQuery=true)
	int[] getDifficulty(String diff);
	
	
	@Query(value = "select* from exercise where type = ?1", nativeQuery=true)
	int[] getType(String type);
}

