package com.stockExchange.utils;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {

	private int statusCode;
	private String message;
	private Object data;
	
	
	public BaseResponse(HttpStatus statusCode, String message) {
		this.statusCode = statusCode.value();
		this.message = message;
	}


	public BaseResponse(HttpStatus statusCode, String message, Object data) {
		this.statusCode = statusCode.value();
		this.message = message;
		this.data = data;
	}
}
