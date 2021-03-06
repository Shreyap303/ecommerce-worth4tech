package com.worth4tech.ecommerce.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.worth4tech.ecommerce.user.pojo.User;
import com.worth4tech.ecommerce.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
		List<User> userInfos = userService.getAllUserInfo();
		if (userInfos == null || userInfos.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return userInfos;
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User userRecord) {
		return userService.addUser(userRecord);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User userRecord, @PathVariable Integer id) {
		return userService.updateUser(id,userRecord);
	}
	
	@PutMapping("/user/changePassword/{id}")
	public User updateUserPassword(@RequestBody User userRecord, @PathVariable Integer id) {
		return userService.updatePassword(id,userRecord);
	}
	
	@PutMapping("/user/changeRole/{id}")
	public User updateUserRole(@RequestBody User userRecord, @PathVariable Integer id) {
		return userService.updateRole(id,userRecord);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User userInfo = userService.getUserInfoById(id);
		if (userInfo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}
}