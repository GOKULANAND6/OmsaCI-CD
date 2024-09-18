package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Premium;

public interface PremiumRepo 
{
	public void savePremium(Premium premium);

	public List<Premium> findAllPremiums();

	public void updatePremium(Premium premium);

	public void deletePremiumById(int premiumId);
	
	public Premium findPremiumById(int premiumId);
}
