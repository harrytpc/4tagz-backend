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

import com.fourtagz.bo.RelationshipBO;
import com.fourtagz.model.Profile;
import com.fourtagz.model.Relationship;

@RestController
@RequestMapping("relationship")
public class RelationshipRest {
	
	@Autowired
	private RelationshipBO relationshipBO;
	
	/**
	 * 
	 * Create a new user
	 * 
	 * @param user object
	 * @return user object with ID 
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<Relationship> create(@RequestBody Relationship relationship) {
		Relationship r = relationshipBO.insert(relationship);
		return new ResponseEntity<Relationship>(r, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Relationship>> getUserProfiles(@PathVariable("userId") Long userId) {
		List<Relationship> relationList = relationshipBO.list(userId);
		return new ResponseEntity<List<Relationship>>(relationList, HttpStatus.OK);	
	}
	
}
