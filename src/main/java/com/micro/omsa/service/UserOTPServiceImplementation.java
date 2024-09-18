package com.micro.omsa.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.micro.omsa.model.UserOTP;
import com.micro.omsa.repo.UserOTPRepo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class UserOTPServiceImplementation implements UserOTPService {

    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Autowired
    private UserOTPRepo repo;

    @PostConstruct
    private void init() {
        Twilio.init(twilioAccountSid, twilioAuthToken);
        System.out.println("Twilio initialized with SID: " + twilioAccountSid);
    }

    @Override
    public String generateOtp(String userMobile) {
        String otp = String.format("%04d", new Random().nextInt(10000));
        UserOTP userOTP = new UserOTP();
        userOTP.setUserMobile(userMobile.trim());
        userOTP.setOtp(otp.trim());
        userOTP.setCreatedAt(LocalDateTime.now());
        repo.save(userOTP);

        sendSms(userMobile, "Your OTP code is: " + otp);

        System.out.println("Generated OTP: " + otp);
        return otp;
    }


    public boolean validateOtp(String userMobile, String otp) {
        UserOTP userOTP = repo.findByUserMobile(userMobile.trim());

        if (userOTP != null) {
            String storedOtp = userOTP.getOtp().trim();
            String providedOtp = otp.trim();

            System.out.println("Raw Stored OTP: '" + storedOtp + "' Length: " + storedOtp.length());
            System.out.println("Raw Provided OTP: '" + providedOtp + "' Length: " + providedOtp.length());

            storedOtp = storedOtp.trim();
            providedOtp = providedOtp.trim();

            System.out.println("Trimmed Stored OTP: '" + storedOtp + "'");
            System.out.println("Trimmed Provided OTP: '" + providedOtp + "'");

            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime createdAt = userOTP.getCreatedAt();
            LocalDateTime expiryTime = createdAt.plusMinutes(5);

            System.out.println("OTP Created At: " + createdAt);
            System.out.println("Current Time: " + currentTime);
            System.out.println("Expiry Time: " + expiryTime);

            if (storedOtp.equals(providedOtp) && currentTime.isBefore(expiryTime)) {
                return true;
            } else {
                System.out.println("OTP validation failed. Stored OTP: '" + storedOtp + "', Provided OTP: '" + providedOtp + "'");
            }
        } else {
            System.out.println("User not found for mobile: " + userMobile);
        }

        return false;
    }



    @Override
    public void sendSms(String to, String body) {
        try {
            String formattedTo = formatPhoneNumber(to);
            PhoneNumber toPhoneNumber = new PhoneNumber(formattedTo);
            PhoneNumber fromPhoneNumber = new PhoneNumber(twilioPhoneNumber);

            Message message = Message.creator(
                    toPhoneNumber,
                    fromPhoneNumber,
                    body
            ).create();

            System.out.println("Message sent: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Failed to send SMS: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.startsWith("+")) {
            return phoneNumber;
        }
        return "+91" + phoneNumber;
    }
}
