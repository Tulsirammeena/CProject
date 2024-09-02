package com.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockExchange.dao.UserService;
import com.stockExchange.dto.LoginModel;
import com.stockExchange.dto.UserModel;
import com.stockExchange.utils.BaseResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	private ResponseEntity<BaseResponse> login(@RequestBody LoginModel login) {
		
		BaseResponse response = userService.login(login);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	@PostMapping("/register")
	private ResponseEntity<BaseResponse> register(@RequestBody UserModel user) {
		
		BaseResponse response = userService.register(user);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
}
