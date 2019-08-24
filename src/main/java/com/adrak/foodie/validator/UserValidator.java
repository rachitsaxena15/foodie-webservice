package com.adrak.foodie.validator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.adrak.foodie.entity.User;
import com.adrak.foodie.service.UserServiceImpl;

@Component
public class UserValidator {

	/**
	 * Validate incoming User details.
	 */
	public boolean validateNewUser(UserServiceImpl service, User user) {
		if(!validateEmail(user.getEmail()))
			return false;
		if(!validatePhone(user.getPhone()))
			return false;
		if(!validateName(user.getName()))
			return false;
		return true;
	}
	
	private boolean validateName(String name) {
		if(name.length() > 50 || name.length() == 0)
			return false;
		return true;
			
	}
	private boolean validateEmail(String email) {
		//Use regex to validate
		return true;
	}
	
	private boolean validatePhone(String phone) {
		//Use regex to validate
		return true;
	}
}
