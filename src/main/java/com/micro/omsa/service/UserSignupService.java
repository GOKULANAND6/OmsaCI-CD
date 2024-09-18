package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.UserSignup;

public interface UserSignupService 
{
	public void addUser(UserSignup user);
	 
	public List<UserSignup> getallUsers();

	public void updateUser(UserSignup user);

	public void deleteUser(int userId);
	
	public UserSignup findUserById(int userId);
}
