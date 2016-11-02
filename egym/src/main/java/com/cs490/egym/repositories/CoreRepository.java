package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.CoreImpl;

public interface CoreRepository extends JpaRepository<CoreImpl, Integer> {

}
