package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.Weightlifting;

public interface WeightliftingRepository extends JpaRepository<Weightlifting, Integer> {

}
