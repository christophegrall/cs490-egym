package com.cs490.egym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs490.egym.models.ExerciseImpl;

public interface ExerciseRepository extends JpaRepository<ExerciseImpl, Integer> {
	@Query(value = "select * from exercise where difficulty = ?1", nativeQuery=true)
	List<ExerciseImpl> getDifficulty(String diff);
	
	@Query(value = "select * from exercise where type = ?1", nativeQuery=true)
	List<ExerciseImpl> getType(String type);

	ExerciseImpl findByName(String name);
	
	@Query(value = "SELECT * FROM EXERCISE WHERE USER_ID IS NULL UNION ALL SELECT * FROM EXERCISE WHERE USER_ID=?1", nativeQuery=true)
	List<ExerciseImpl> findAllByUser(Integer userId);
}

