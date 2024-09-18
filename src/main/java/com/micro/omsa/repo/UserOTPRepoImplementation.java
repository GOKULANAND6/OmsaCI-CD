package com.micro.omsa.repo;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.UserOTP;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserOTPRepoImplementation implements UserOTPRepo
{
	EntityManager manager;

	public UserOTPRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
    public UserOTP save(UserOTP userOTP) {
        if (userOTP.getUserId() == 0) {
            manager.persist(userOTP);
        } else {
            userOTP = manager.merge(userOTP);
        }
        return userOTP;
    }

	@Override
	public UserOTP findByUserMobile(String userMobile) {
	    String str = "SELECT u FROM UserOTP u WHERE u.userMobile = :name";
	    TypedQuery<UserOTP> query = manager.createQuery(str, UserOTP.class);
	    query.setParameter("name", userMobile);
	    return query.getResultStream().findFirst().orElse(null);
	}

}
