package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.Cardio;

public interface CardioRepository extends JpaRepository<Cardio, Integer> {

}
