package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
