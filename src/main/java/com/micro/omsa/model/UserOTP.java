package com.micro.omsa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="userotp")
public class UserOTP 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false)
	private String userMobile;
	@Column(nullable = false)
	private String otp;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	public UserOTP() 
	{
		super();
	}

	public UserOTP(int userId, String userMobile, String otp, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.userMobile = userMobile;
		this.otp = otp;
		this.createdAt = createdAt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserOTP [userId=" + userId + ", userMobile=" + userMobile + ", otp=" + otp + ", createdAt=" + createdAt
				+ "]";
	}
}
