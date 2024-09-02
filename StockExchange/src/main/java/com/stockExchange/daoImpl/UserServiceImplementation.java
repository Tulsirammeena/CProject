package com.stockExchange.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stockExchange.Entity.UserEntity;
import com.stockExchange.dao.UserService;
import com.stockExchange.dto.LoginModel;
import com.stockExchange.dto.UserModel;
import com.stockExchange.repository.UserRepo;
import com.stockExchange.utils.BaseResponse;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepo exchangeRepo;
	
	@Override
	public BaseResponse login(LoginModel login) {
		
		if(login.getUserName().isBlank() || login.getPassword().isBlank()) {
			return new BaseResponse(HttpStatus.BAD_REQUEST, "UserName or Password should not be empty");
		}
		
		Optional<UserEntity> data = exchangeRepo.findByUsernameAndPasswordAndRole(login.getUserName(), login.getPassword(), login.getRole());
		
		if(!data.isPresent()) {
			return new BaseResponse(HttpStatus.NOT_FOUND, "User not found");
		}
		
		return new BaseResponse(HttpStatus.OK, "Login successful", data);
	}

	@Override
	public BaseResponse register(UserModel user) {
		
		if(user.getUserName().isBlank() || user.getPassword().isBlank() || user.getFirstName().isBlank() 
				|| user.getLastName().isBlank() || user.getEmail().isBlank() || user.getNumber() == 0 
				|| user.getRole().isBlank() || user.getPan().isBlank()) {
			return new BaseResponse(HttpStatus.BAD_REQUEST, "Some data is missing");
		}
		
		UserEntity newUser = new UserEntity(user);
		exchangeRepo.save(newUser);
		
		return new BaseResponse(HttpStatus.OK, "Registration successful", newUser);
	}

	@Override
	public BaseResponse updateUser(UserEntity user) {
		return null;
	}

}
