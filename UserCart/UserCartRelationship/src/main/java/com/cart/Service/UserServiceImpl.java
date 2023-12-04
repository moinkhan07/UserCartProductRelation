package com.cart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Model.Users;
import com.cart.Repo.UserRepo;

@Service
public class UserServiceImpl implements UsersService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Users registerUser(Users users) {
		return userRepo.save(users);
	}

	@Override
	public Users getUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}

}
