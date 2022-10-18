package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	public User saveUser(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setAge(userRequest.getAge());
		user.setEmail(userRequest.getEmail());
		user.setGender(userRequest.getGender());
		user.setBio(userRequest.getBio());
		user.setMobileNumber(userRequest.getMobileNumber());
		user.setPassword(userRequest.getPassword());
		return userRepo.save(user);
	}
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User getUser(String email) {
		return userRepo.findByEmail(email);
	}
	
	public List<User> search(String search){
		return userRepo.search(search);
	}
}
