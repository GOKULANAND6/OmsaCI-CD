package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Admin;

public interface AdminService 
{
	public void addAdmin(Admin admin);
	 
	public List<Admin> getallAdmins();

	public void updateAdmin(Admin admin);

	public void deleteAdmin(int adminId);
		
	public Admin findAdminByName(String adminName);

}
