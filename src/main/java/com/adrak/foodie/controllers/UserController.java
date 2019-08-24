package com.adrak.foodie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adrak.foodie.entity.User;
import com.adrak.foodie.service.UserServiceImpl;
import com.adrak.foodie.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl service;
	
	@Autowired
	UserValidator validator;
	
	@RequestMapping(method = RequestMethod.GET, value="/users/all")
	public @ResponseBody List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/list/{userId}")
	public @ResponseBody User getUser(@PathVariable String userId) {
			long id = Long.parseLong(userId);
			return service.getUser(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(service.isUserExist(user))
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		if(validator.validateNewUser(user)) {
			User us = service.addUser(user);
			return new ResponseEntity<>(us, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		if(!service.isUserExist(user))
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		if(validator.validateNewUser(user)) {
			User us = service.addUser(user);
			return new ResponseEntity<>(us, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	// Do we need this?
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{userId}")
	public ResponseEntity<Void> delete(@PathVariable String userId){
		long id = Long.parseLong(userId); 
		User user = service.getUser(id);
		if(service.isUserExist(user)) {
			service.deleteUser(user);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
