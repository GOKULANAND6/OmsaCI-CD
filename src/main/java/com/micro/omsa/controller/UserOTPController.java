package com.micro.omsa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.omsa.service.UserOTPService;

@RestController
@RequestMapping("/userotp")
@CrossOrigin(origins = "http://localhost:3000")
public class UserOTPController {

    private final UserOTPService service;

    public UserOTPController(UserOTPService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public String generateOtp(@RequestParam String userMobile) {
        return service.generateOtp(userMobile);
    }

    @PostMapping("/validate")
    public boolean validateOtp(@RequestParam String userMobile, @RequestParam String otp) {
        return service.validateOtp(userMobile, otp);
    }
}
