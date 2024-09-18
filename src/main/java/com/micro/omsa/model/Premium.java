package com.micro.omsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="premium")
public class Premium 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int premiumId;
	private String premiumName;
	private String premiumvalidity;
	private String premiumPrice;
	private String premiumDescription;
	
	public Premium() 
	{
		super();
	}

	public Premium(int premiumId, String premiumName, String premiumvalidity, String premiumPrice,
			String premiumDescription) {
		super();
		this.premiumId = premiumId;
		this.premiumName = premiumName;
		this.premiumvalidity = premiumvalidity;
		this.premiumPrice = premiumPrice;
		this.premiumDescription = premiumDescription;
	}

	public int getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(int premiumId) {
		this.premiumId = premiumId;
	}

	public String getPremiumName() {
		return premiumName;
	}

	public void setPremiumName(String premiumName) {
		this.premiumName = premiumName;
	}

	public String getPremiumvalidity() {
		return premiumvalidity;
	}

	public void setPremiumvalidity(String premiumvalidity) {
		this.premiumvalidity = premiumvalidity;
	}

	public String getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(String premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public String getPremiumDescription() {
		return premiumDescription;
	}

	public void setPremiumDescription(String premiumDescription) {
		this.premiumDescription = premiumDescription;
	}

	@Override
	public String toString() {
		return "Premium [premiumId=" + premiumId + ", premiumName=" + premiumName + ", premiumvalidity="
				+ premiumvalidity + ", premiumPrice=" + premiumPrice + ", premiumDescription=" + premiumDescription
				+ "]";
	}
}
