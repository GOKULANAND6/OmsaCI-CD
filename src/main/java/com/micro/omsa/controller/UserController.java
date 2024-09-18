package com.micro.omsa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.omsa.model.UserSignup;
import com.micro.omsa.service.UserSignupServiceImplementation;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController 
{
	UserSignupServiceImplementation service;

	public UserController(UserSignupServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  String insertUser(@RequestBody UserSignup user)
	{
	String msg = "";
	try {
	service.addUser(user);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<UserSignup> readAllUsers()
	{
	return service.getallUsers();
	}

	@PutMapping
	public  String updateUser(@RequestBody UserSignup user)
	{
	String msg = "";
	try {
	service.updateUser(user);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{userId}")
	public String deleteUserbyId(@PathVariable("userId") int userId)
	{
	String msg = "";
	try {
	service.deleteUser(userId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{userId}")
	public UserSignup findUser(@PathVariable("userId") int userId)
	{
			return service.findUserById(userId);
	}
}
