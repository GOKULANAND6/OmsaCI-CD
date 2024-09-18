package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Payment;
import com.micro.omsa.repo.PaymentRepo;

@Service
public class PaymentServiceImplementation implements PaymentService
{
	PaymentRepo repo;
	
	public PaymentServiceImplementation(PaymentRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addPayment(Payment payment) 
	{
		repo.savePayment(payment);
	}

	@Override
	public List<Payment> getallPayments() 
	{
		return repo.findAllPayments();
	}

	@Override
	public void updatePayment(Payment payment) 
	{
		repo.updatePayment(payment);
	}

	@Override
	public void deletePayment(int paymentId) 
	{
		repo.deletePaymentById(paymentId);
	}
}
