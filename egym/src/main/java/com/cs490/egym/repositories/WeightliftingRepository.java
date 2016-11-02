package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.WeightliftingImpl;

public interface WeightliftingRepository extends JpaRepository<WeightliftingImpl, Integer> {

}
