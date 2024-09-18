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

import com.micro.omsa.model.Admin;
import com.micro.omsa.service.AdminServiceImplementation;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController 
{
	AdminServiceImplementation service;

	public AdminController(AdminServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  String insertAdmin(@RequestBody Admin admin)
	{
	String msg = "";
	try {
	service.addAdmin(admin);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<Admin> readAllAdmins()
	{
	return service.getallAdmins();
	}

	@PutMapping
	public  String updateAdmin(@RequestBody Admin admin)
	{
	String msg = "";
	try {
	service.updateAdmin(admin);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{adminId}")
	public String deleteAdminbyId(@PathVariable("adminId") int adminId)
	{
	String msg = "";
	try {
	service.deleteAdmin(adminId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{adminName}")
	public Admin findUser(@PathVariable("adminName") String adminName)
	{
			return service.findAdminByName(adminName);
	}
}
