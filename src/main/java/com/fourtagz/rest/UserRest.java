package com.fourtagz.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fourtagz.bo.ProfileBO;
import com.fourtagz.bo.RelationshipBO;
import com.fourtagz.bo.UserBO;
import com.fourtagz.model.Profile;
import com.fourtagz.model.Relationship;
import com.fourtagz.model.User;

@RestController
@RequestMapping("users")
public class UserRest {

	@Autowired
	private UserBO userBO;
	
	@Autowired
	private ProfileBO profileBO;
	
	@Autowired
	private RelationshipBO relationshipBO;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable("id") String userId) {
		User user = userBO.getById(userId);
		if(user != null)
			user.setProfile(profileBO.getById(userId));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		// TODO inserir usuario
		
		User u = userBO.getByEmail(user.getEmail());
		
		if(u != null){
			System.out.println("User already exists.");
	    	return new ResponseEntity<User>(HttpStatus.OK);
		}
		
		user.setId(UUID.randomUUID().toString());
		User newUser = userBO.insert(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
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
	
	@RequestMapping(value = "/{id}/profiles/", method = RequestMethod.GET)
	public ResponseEntity<List<Profile>> getUserProfiles(@PathVariable("id") String userId) {
		List<Profile> profileList = profileBO.getById(userId);
		return new ResponseEntity<List<Profile>>(profileList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}/relationships/", method = RequestMethod.GET)
	public ResponseEntity<List<Relationship>> getUserRelations(@PathVariable("id") String userId) {
		List<Relationship> relationList = relationshipBO.list(userId);
		return new ResponseEntity<List<Relationship>>(relationList, HttpStatus.OK);	
	}
	
}
