package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Premium;

public interface PremiumService 
{
	public void addPremium(Premium premium);
	 
	public List<Premium> getallPremiums();

	public void updatePremium(Premium premium);

	public void deletePremium(int premiumId);
	
	public Premium findPremiumById(int premiumId);
}
