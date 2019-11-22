package com.nested.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nested.User;

public interface UsersRepository extends CrudRepository<User, String>{

	User findByUserName(String userName);
	
}