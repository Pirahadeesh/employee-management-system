package com.employeemanagementSys.Springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employeemanagementSys.Springboot.dao.UserRepository;
import com.employeemanagementSys.Springboot.entity.User;
import com.employeemanagementSys.Springboot.exception.ResourceNotFoundDException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	/* TO CRETAE INDIVIDUVAL USER */
	public User createuser(User user) {
		return userRepository.save(user);
	}

	/* TO CRETAE MULTIPLE USER */
	public List<User> createusers(List<User> users) {
		return userRepository.saveAll(users);
	}

	/* TO GET USER BY ID */
	
	public User getUserById(int id) {
		return 
				userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundDException("Employee not exist with id:"+ id));
		
	}

	/* TO GET MULTIPLE USER */
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/* TO UPDATE USER */
	public User updateUser(User user) {
		User oldUser = null;
		Optional<User> optionaluser = userRepository.findById(user.getId());
		if (optionaluser.isPresent()) {
			oldUser = optionaluser.get();
			oldUser.setName(user.getName());
			oldUser.setLocation(user.getLocation());
			userRepository.save(oldUser);
		} else {
			return new User();
		}
		return oldUser;
	}

	/* TO DELETE USER */
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User Got Deleted";
	}
}
