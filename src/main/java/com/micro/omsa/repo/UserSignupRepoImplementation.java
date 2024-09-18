package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.UserSignup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserSignupRepoImplementation implements UserSignupRepo
{
	EntityManager manager;

	public UserSignupRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveUser(UserSignup user) 
	{
		manager.persist(user);
	}

	@Override
	public List<UserSignup> findAllUsers() 
	{
		String str = "From UserSignup";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateUser(UserSignup user) 
	{
		manager.merge(user);
	}

	@Override
	public void deleteUserById(int userId) 
	{
		UserSignup user = manager.find(UserSignup.class, userId);
		manager.remove(user);
	}

	@Override
	public UserSignup findUserById(int userId) 
	{
		return manager.find(UserSignup.class, userId);
	}
}
