package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentRepoImplementation implements PaymentRepo
{
	EntityManager manager;

	public PaymentRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void savePayment(Payment payment) 
	{
		manager.persist(payment);
	}

	@Override
	public List<Payment> findAllPayments() 
	{
		String str = "From Payment";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updatePayment(Payment payment) 
	{
		manager.merge(payment);
	}

	@Override
	public void deletePaymentById(int paymentId) 
	{
		Payment payment = manager.find(Payment.class, paymentId);
		manager.remove(payment);
	}
}
