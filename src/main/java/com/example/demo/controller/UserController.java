package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save-user")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		userService.saveUser(userRequest);
//		return userService.getUser(userRequest.getEmail());
		return ResponseEntity.ok(userService.getUser(userRequest.getEmail()));
	}
	
	@GetMapping("all-users")
	public ResponseEntity<List<User>> getAllUser(){
//		return userService.getAllUser();
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<User>> search(@RequestParam @Valid String search){
//		return userService.search(search);
		return ResponseEntity.ok(userService.search(search));
	}
}
