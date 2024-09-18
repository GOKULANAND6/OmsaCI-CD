package com.micro.omsa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.omsa.model.Payment;
import com.micro.omsa.model.Premium;
import com.micro.omsa.model.UserSignup;
import com.micro.omsa.service.PaymentServiceImplementation;
import com.micro.omsa.service.PremiumServiceImplementation;
import com.micro.omsa.service.UserSignupServiceImplementation;


@RestController
@RequestMapping("/payment")
@CrossOrigin( origins = "http://localhost:3000")
public class PaymentController 
{
	PaymentServiceImplementation service;
	PremiumServiceImplementation premiumService;
	UserSignupServiceImplementation userService;
	
	public PaymentController(PaymentServiceImplementation service, PremiumServiceImplementation premiumService,
			UserSignupServiceImplementation userService) {
		super();
		this.service = service;
		this.premiumService = premiumService;
		this.userService = userService;
	}

	@PostMapping("/add")
	public ResponseEntity<String> insertPayment(@RequestBody Payment payment) {
	    try {
	        // Fetch Premium and UserSignup entities from their respective services
	        Premium premium = premiumService.findPremiumById(payment.getPremium().getPremiumId());
	        UserSignup user = userService.findUserById(payment.getUser().getUserId());

	        if (premium == null || user == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Premium or User ID");
	        }

	        // Set the fetched entities into the payment object
	        payment.setPremium(premium);
	        payment.setUser(user);

	        // Save the Payment object using the service
	        service.addPayment(payment);

	        return ResponseEntity.status(HttpStatus.CREATED).body("Payment Successfully Done");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Pay: " + e.getMessage());
	    }
	}

	
	@GetMapping("/all")
	public List<Payment> readAllPayments()
	{
	return service.getallPayments();
	}

	@PutMapping
	public  String updatePayment(@RequestBody Payment payment)
	{
	String msg = "";
	try {
	service.updatePayment(payment);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{paymentId}")
	public String deletePaymentbyId(@PathVariable("paymentId") int paymentId)
	{
	String msg = "";
	try {
	service.deletePayment(paymentId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}	
}
