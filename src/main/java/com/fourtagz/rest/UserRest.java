package com.fourtagz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fourtagz.bo.ProfileBO;
import com.fourtagz.bo.UserBO;
import com.fourtagz.model.Relationship;
import com.fourtagz.model.User;

@RestController
@RequestMapping("user")
public class UserRest {

	@Autowired
	private UserBO userBO;
	
	@Autowired
	private ProfileBO profileBO;
	
	/**
	 * 
	 * Create a new user
	 * 
	 * @param user object
	 * @return user object with ID 
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		// TODO inserir usuario
		User u = userBO.insert(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user) {
		// TODO validar se usuario e password estão OK
		User u = userBO.getByEmail(user.getEmail());
		
		if(u == null){
	    	System.out.println("User not found.");
	    	return new ResponseEntity<User>(HttpStatus.OK);
		}
		
		if(!u.getPassword().equals(user.getPassword())){
	    	System.out.println("Invalid password.");
	    	return new ResponseEntity<User>(HttpStatus.OK);
		}
		
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
		User user = userBO.getById(userId);
		user.setProfile(profileBO.getById(userId));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> example() {
		List<User> userList = userBO.example();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
}
