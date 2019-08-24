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
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/list/{name}")
	public @ResponseBody User getUser(@PathVariable String name) {
		try {
			long id = Long.parseLong(name);
			return service.getUser(id);
		}
		catch(Exception e) {
			return service.getUser(name);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(service.isUserExist(user))
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		if(validator.validateNewUser(service, user)) {
			User us = service.addUser(user);
			return new ResponseEntity<>(us, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{name}")
	public void delete(@PathVariable String name){
		User user = service.getAllUsers().stream().filter(us -> us.getName().equals(name)).findFirst().get();
		System.out.println(user.getName());
		service.deleteUser(user);
	}
	
	
}
