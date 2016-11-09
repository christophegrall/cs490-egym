package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cs490.egym.models.ExerciseImpl;

public interface ExerciseRepository extends JpaRepository<ExerciseImpl, Integer> {
}
