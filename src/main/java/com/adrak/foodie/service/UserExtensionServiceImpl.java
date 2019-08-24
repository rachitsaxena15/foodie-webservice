package com.adrak.foodie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrak.foodie.entity.UserExtension;
import com.adrak.foodie.repository.UserExtensionRepository;

@Service
public class UserExtensionServiceImpl implements UserExtensionService{

	@Autowired
	UserExtensionRepository repository;
	
	@Override
	public UserExtension updateUserExtension(UserExtension userExt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserExtension addUserExtension(UserExtension userExt) {
		return repository.save(userExt);
	}

	@Override
	public UserExtension getUserExtensionDetails(UserExtension userExt) {
		// TODO Auto-generated method stub
		return null;
	}

}
