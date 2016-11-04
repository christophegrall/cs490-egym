package com.cs490.egym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.ExerciseImpl;

public interface ExerciseRepository extends JpaRepository<ExerciseImpl, Integer> {
	List<ExerciseImpl> findById(Integer id);
	void deleteById(Integer id);
}
