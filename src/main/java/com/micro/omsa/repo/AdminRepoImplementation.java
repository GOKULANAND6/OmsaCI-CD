package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImplementation implements AdminRepo
{
	EntityManager manager;

	public AdminRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveAdmin(Admin admin) 
	{
		manager.persist(admin);
	}

	@Override
	public List<Admin> findAllAdmins() 
	{
		String str = "From Admin";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateAdmin(Admin admin) 
	{
		manager.merge(admin);
	}

	@Override
	public void deleteAdminById(int adminId) 
	{
		Admin admin = manager.find(Admin.class, adminId);
		manager.remove(admin);
	}

	@Override
	public Admin findAdminByName(String adminName) 
	{
		String str = "From Admin where adminName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", adminName);
		return (Admin) query.getSingleResult();
	}
}
