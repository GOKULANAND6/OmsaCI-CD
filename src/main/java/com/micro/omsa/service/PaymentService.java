package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Payment;

public interface PaymentService 
{
	public void addPayment(Payment payment);
	 
	public List<Payment> getallPayments();

	public void updatePayment(Payment payment);

	public void deletePayment(int paymentId);
}
