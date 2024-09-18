package com.micro.omsa.service;

public interface UserOTPService 
{
	String generateOtp(String userMobile);
    boolean validateOtp(String userMobile, String otp);
    void sendSms(String to, String body);
}
