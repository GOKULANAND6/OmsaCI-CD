package com.micro.omsa.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name="payment")
public class Payment 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String payerName;
	private Date transactionDate;
	private String upiId;
	private String amount;
	
	@OneToOne(targetEntity = Premium.class, cascade = CascadeType.ALL)
	private Premium premium;	
	
	@OneToOne(targetEntity = UserSignup.class, cascade = CascadeType.ALL)
	private UserSignup user;
	
	public Payment() 
	{
		super();
	}

	public Payment(int paymentId, String payerName, Date transactionDate, String upiId, String amount, Premium premium,
			UserSignup user) {
		super();
		this.paymentId = paymentId;
		this.payerName = payerName;
		this.transactionDate = transactionDate;
		this.upiId = upiId;
		this.amount = amount;
		this.premium = premium;
		this.user = user;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Premium getPremium() {
		return premium;
	}

	public void setPremium(Premium premium) {
		this.premium = premium;
	}

	public UserSignup getUser() {
		return user;
	}

	public void setUser(UserSignup user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", payerName=" + payerName + ", transactionDate=" + transactionDate
				+ ", upiId=" + upiId + ", amount=" + amount + ", premium=" + premium + ", user=" + user + "]";
	}
}
