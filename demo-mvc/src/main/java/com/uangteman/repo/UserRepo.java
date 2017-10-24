package com.uangteman.repo;

import org.springframework.data.repository.CrudRepository;

import com.uangteman.entity.User;

public interface UserRepo extends CrudRepository<User, Long>{
	
	public User findByEmailAndPassword(String email, String password);
}
