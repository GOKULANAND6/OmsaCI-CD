package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Admin;

public interface AdminRepo 
{
	public void saveAdmin(Admin admin);

	public List<Admin> findAllAdmins();

	public void updateAdmin(Admin admin);

	public void deleteAdminById(int adminId);
		
	public Admin findAdminByName(String adminName);
}
