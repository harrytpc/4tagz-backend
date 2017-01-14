package com.fourtagz.bo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourtagz.model.User;
import com.fourtagz.repository.UserRepository;

@Service
public class UserBO {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * insert user
	 * 
	 * @param user
	 * @return
	 */
	public User insert(User user){
		user = userRepository.save(user);
		return user;
	}
	
	public User getById(Long userId){
		User user = userRepository.findOne(userId);
		return user;
	}
	
	public List<User> example(){
		List<User> userList = userRepository.example();
		return userList;
	}

}
