package com.fourtagz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fourtagz.bo.ProfileBO;
import com.fourtagz.model.Profile;
import com.fourtagz.model.User;

@RestController
@RequestMapping("profile")
public class ProfileRest {
	
	@Autowired
	private ProfileBO profileBO;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Profile>> getUserProfiles(@PathVariable("userId") Long userId) {
		List<Profile> profileList = profileBO.getById(userId);
		return new ResponseEntity<List<Profile>>(profileList, HttpStatus.OK);		
		
	}


}
