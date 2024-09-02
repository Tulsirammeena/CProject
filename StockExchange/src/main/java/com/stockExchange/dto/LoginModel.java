package com.stockExchange.dto;

import lombok.Data;

@Data
public class LoginModel {

	private String userName;
	private String password;
	private String role;
}
