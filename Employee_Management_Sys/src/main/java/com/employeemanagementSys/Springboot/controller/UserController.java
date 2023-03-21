package com.employeemanagementSys.Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementSys.Springboot.entity.User;
import com.employeemanagementSys.Springboot.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user ) {
		return userservice.createuser(user);
	}
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users){
		return userservice.createusers(users);
	}
	@GetMapping("/user/{id}")
 public User getUserById(@PathVariable int id) {
	 return userservice.getUserById(id);
 }
	
	
	@GetMapping("/users")
	public List<User>getAllUsers(){
		return userservice.getUsers();
	}
	
	
	
	
	@PutMapping("/upuser")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}
	
	@DeleteMapping("/use/{id}")
	public String deleteUser(@PathVariable int id) {
		return userservice.deleteUserById(id);
	}
}
