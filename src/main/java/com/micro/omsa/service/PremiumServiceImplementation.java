package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Premium;
import com.micro.omsa.repo.PremiumRepo;

@Service
public class PremiumServiceImplementation implements PremiumService
{
	PremiumRepo repo;

	public PremiumServiceImplementation(PremiumRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addPremium(Premium premium) 
	{
		repo.savePremium(premium);
	}

	@Override
	public List<Premium> getallPremiums() 
	{
		return repo.findAllPremiums();
	}

	@Override
	public void updatePremium(Premium premium) 
	{
		repo.updatePremium(premium);
	}

	@Override
	public void deletePremium(int premiumId) 
	{
		repo.deletePremiumById(premiumId);
	}

	@Override
	public Premium findPremiumById(int premiumId) 
	{
		return repo.findPremiumById(premiumId);
	}
}
