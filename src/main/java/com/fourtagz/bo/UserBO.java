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
	
	public User getById(String userId){
		User user = userRepository.findOne(userId);
		return user;
	}
	
	public User getByEmail(String email){
		List<User> userList = userRepository.findByEmail(email);
		
		if(userList == null){
			return null;
		}
		
		if(userList.size() == 1){
			return userList.get(0);
		}
		
		return null;
	}	

}
