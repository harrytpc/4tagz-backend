package com.fourtagz.repository;

import org.springframework.data.repository.CrudRepository;

import com.fourtagz.model.User;


public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom{
	
	
}
