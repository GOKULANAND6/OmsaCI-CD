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

import com.micro.omsa.model.Premium;
import com.micro.omsa.service.PremiumServiceImplementation;

@RestController
@RequestMapping("/premium")
@CrossOrigin(origins = "http://localhost:3000")
public class PremiumController 
{
	PremiumServiceImplementation service;

	public PremiumController(PremiumServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  String insertPremium(@RequestBody Premium premium)
	{
	String msg = "";
	try {
	service.addPremium(premium);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<Premium> readAllPremiums()
	{
	return service.getallPremiums();
	}

	@PutMapping
	public  String updatePremium(@RequestBody Premium premium)
	{
	String msg = "";
	try {
	service.updatePremium(premium);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{premiumId}")
	public String deletePremiumbyId(@PathVariable("premiumId") int premiumId)
	{
	String msg = "";
	try {
	service.deletePremium(premiumId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{premiumId}")
	public Premium findUser(@PathVariable("premiumId") int premiumId)
	{
			return service.findPremiumById(premiumId);
	}
}
