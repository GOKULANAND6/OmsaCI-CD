package com.micro.omsa.repo;

import com.micro.omsa.model.UserOTP;

public interface UserOTPRepo 
{
	UserOTP save(UserOTP userOTP);
	UserOTP findByUserMobile(String userMobile);
}
