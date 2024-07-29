package com.e_commerce.userScervice;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.exception.ResourceNotFoundException;
import com.e_commerce.userEntity.UserEntity;
import com.e_commerce.userRepostory.UserRepository;
@Service
public class UserSerice {
	@Autowired
	UserRepository userRepository;
	
	
	public UserEntity register(UserEntity userEntity)
	{
		userEntity.setUserId(UUID.randomUUID().toString());
		userEntity.setCreatedAt(LocalDateTime.now());
		return userRepository.save(userEntity);
		
	}
	
	public UserEntity getUser(String userId)
	{
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
		
	}
	
	public UserEntity updateUser(String userId, UserEntity userEntity)
	{
		UserEntity user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
		if(user!=null)
		{
			user.setUserName(userEntity.getUserName());	
			user.setEmail(userEntity.getEmail());
			return userRepository.save(user);
		}
		return null; 
	}
	
	public UserEntity loginUser(String email,String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
		
	}

}
