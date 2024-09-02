
package com.stockExchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockExchange.Entity.UserEntity;

@Repository
public interface UserAccountRepo extends JpaRepository<UserEntity,Integer>{

	@Query(value = "select * from user_details u where u.email_id = ?",nativeQuery = true)
	Optional<UserEntity> findByEmailId(String email);
	
	@Query(value = "select * from user_details u where u.email_id = ?",nativeQuery = true)
	UserEntity getByEmailId(String email);
	
}
