package com.e_commerce.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.userEntity.UserEntity;
import com.e_commerce.userScervice.UserSerice;

@RestController
@RequestMapping("/userservice")
public class UserController {
	@Autowired
	UserSerice userSerice;
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> register(@RequestBody UserEntity userEntity)
	{
	UserEntity user =	userSerice.register(userEntity);
	System.out.println(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);	
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable String userId)
	{
		UserEntity user =	userSerice.getUser(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);	
	}
	@PutMapping("/{userId}")
	public ResponseEntity<UserEntity> updateUser(@ PathVariable String userId,@RequestBody UserEntity userEntity)
	{
	 UserEntity user =	userSerice.updateUser(userId, userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(user);		
	}
	@GetMapping("/login")
	public ResponseEntity<UserEntity> loginUser(@RequestParam String email, @RequestParam String password)
	{
	 UserEntity user =	userSerice.loginUser(email, password);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		
	}

}
