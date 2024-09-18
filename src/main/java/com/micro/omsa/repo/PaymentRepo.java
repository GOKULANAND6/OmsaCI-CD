package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Payment;

public interface PaymentRepo 
{
	public void savePayment(Payment payment);

	public List<Payment> findAllPayments();

	public void updatePayment(Payment payment);

	public void deletePaymentById(int paymentId);
}
