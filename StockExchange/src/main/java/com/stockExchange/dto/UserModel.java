package com.stockExchange.dto;

import lombok.Data;

@Data
public class UserModel {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String pan;
	private Long number;
	private String role;
	private String password;
}
