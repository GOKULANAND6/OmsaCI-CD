package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Premium;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PremiumRepoImplementation implements PremiumRepo
{
	EntityManager manager;

	public PremiumRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void savePremium(Premium premium) 
	{
		manager.persist(premium);
	}

	@Override
	public List<Premium> findAllPremiums() 
	{
		String str = "From Premium";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updatePremium(Premium premium) 
	{
		manager.merge(premium);
	}

	@Override
	public void deletePremiumById(int premiumId) 
	{
		Premium premium = manager.find(Premium.class, premiumId);
		manager.remove(premium);
	}

	@Override
	public Premium findPremiumById(int premiumId) 
	{
		return manager.find(Premium.class, premiumId);
	}
}
