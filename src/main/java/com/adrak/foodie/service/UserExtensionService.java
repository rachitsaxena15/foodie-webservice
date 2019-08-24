package com.adrak.foodie.service;

import com.adrak.foodie.entity.UserExtension;

public interface UserExtensionService {

	public UserExtension updateUserExtension(UserExtension userExt);
	public UserExtension addUserExtension(UserExtension userExt);
	public UserExtension getUserExtensionDetails(UserExtension userExt);
}
