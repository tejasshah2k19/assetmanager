package com.slk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.entity.EquityEntity;

@Repository
public interface EquityRepository extends JpaRepository<EquityEntity, Integer> {

	Optional<EquityEntity> findByEquityName(String name);
	Optional<EquityEntity> findBySymbol(String symbol);
	
	
}
