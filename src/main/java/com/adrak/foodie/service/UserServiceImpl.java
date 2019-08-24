package com.adrak.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrak.foodie.entity.User;
import com.adrak.foodie.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public User addUser(User user) {
		repository.save(user);
		return user;
	}

	@Override
	public User getUser(long id) {
		User user = null;
		Optional<User> opt = repository.findById(id);
		if(opt.isPresent())
			user = opt.get();
		System.out.println(user.toString());
		return user;
	}
	
	@Override
	public User getUser(String email) {
		Optional<User> opt = repository.findAll().stream().filter(u -> u.getEmail().equals(email)).findFirst(); 
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		repository.delete(user);		
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		return repository.existsById(user.getId());
	}

}
