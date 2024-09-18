package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.UserSignup;

public interface UserSignupRepo 
{
	public void saveUser(UserSignup user);

	public List<UserSignup> findAllUsers();

	public void updateUser(UserSignup user);

	public void deleteUserById(int userId);
	
	public UserSignup findUserById(int userId);
}
