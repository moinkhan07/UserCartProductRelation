package com.cart.Service;

import com.cart.Model.Users;

public interface UsersService {
	
	public Users registerUser(Users users);

	public Users getUserById(Long userId);
}