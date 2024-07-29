package com.e_commerce.userRepostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e_commerce.userEntity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	@Query("select user from UserEntity user where user.email=:email and user.password=:password")
	public UserEntity findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	

}
