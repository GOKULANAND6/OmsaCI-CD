package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Admin;
import com.micro.omsa.repo.AdminRepo;

@Service
public class AdminServiceImplementation implements AdminService
{
	AdminRepo repo;
	
	public AdminServiceImplementation(AdminRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addAdmin(Admin admin) 
	{
		repo.saveAdmin(admin);
	}

	@Override
	public List<Admin> getallAdmins() 
	{
		return repo.findAllAdmins();
	}

	@Override
	public void updateAdmin(Admin admin) 
	{
		repo.updateAdmin(admin);
	}

	@Override
	public void deleteAdmin(int adminId) 
	{
		repo.deleteAdminById(adminId);
	}

	@Override
	public Admin findAdminByName(String adminName) 
	{
		return repo.findAdminByName(adminName);
	}
}
