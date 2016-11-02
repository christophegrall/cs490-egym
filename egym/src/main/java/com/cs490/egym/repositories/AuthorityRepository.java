package com.cs490.egym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs490.egym.models.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
	
}
