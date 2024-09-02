package com.stockExchange.dao;

import com.stockExchange.Entity.UserEntity;
import com.stockExchange.dto.LoginModel;
import com.stockExchange.dto.UserModel;
import com.stockExchange.utils.BaseResponse;

public interface UserService{

	public BaseResponse login(LoginModel login);
	public BaseResponse register(UserModel user);
	public BaseResponse updateUser(UserEntity user);
}
