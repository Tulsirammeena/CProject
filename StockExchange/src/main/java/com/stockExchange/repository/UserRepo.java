package com.stockExchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockExchange.Entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findByUsernameAndPasswordAndRole(String userName, String password, String role);
}
