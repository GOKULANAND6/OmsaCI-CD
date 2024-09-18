package com.micro.omsa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="user")
public class UserSignup 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private Date userDob;
	private String userGender;
	private String userPassword;
	
	public UserSignup() 
	{
		super();
	}

	public UserSignup(int userId, String userName, Date userDob, String userGender, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDob = userDob;
		this.userGender = userGender;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserSignup [userId=" + userId + ", userName=" + userName + ", userDob=" + userDob + ", userGender="
				+ userGender + ", userPassword=" + userPassword + "]";
	}
}
