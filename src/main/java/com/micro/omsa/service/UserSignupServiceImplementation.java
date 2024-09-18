package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.UserSignup;
import com.micro.omsa.repo.UserSignupRepo;

@Service
public class UserSignupServiceImplementation implements UserSignupService
{
	UserSignupRepo repo;
	
	public UserSignupServiceImplementation(UserSignupRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addUser(UserSignup user) 
	{
		repo.saveUser(user);
	}

	@Override
	public List<UserSignup> getallUsers() 
	{
		return repo.findAllUsers();
	}

	@Override
	public void updateUser(UserSignup user) 
	{
		repo.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) 
	{
		repo.deleteUserById(userId);
	}

	@Override
	public UserSignup findUserById(int userId) 
	{
		return repo.findUserById(userId);
	}
}
