package com.slk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByEmail(String email);// findByXXX

	
	//sql    
	@Query(value = "select * from users where deleted_at is null", nativeQuery = true)
	List<UserEntity> getActiveUsers();
}
//block unblock 