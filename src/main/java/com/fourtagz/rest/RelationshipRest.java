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
import com.fourtagz.model.Relationship;

@RestController
@RequestMapping("relationship")
public class RelationshipRest {
	
	@Autowired
	private RelationshipBO relationshipBO;
	
	/**
	 * 
	 * Create a new relationship
	 * 
	 * @param user object
	 * @return user object with ID 
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<Relationship> create(@RequestBody Relationship relationship) {
		Relationship r = relationshipBO.insert(relationship);
		return new ResponseEntity<Relationship>(r, HttpStatus.CREATED);
	}
	
	/***
	 * deletes the relationship
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Relationship> delete(@PathVariable("id") long id) {
				
        Relationship relationship = relationshipBO.findById(id);
        
        if (relationship == null) {
            System.out.println("Unable to delete. Relationship with id " + id + " not found");
            return new ResponseEntity<Relationship>(HttpStatus.NOT_FOUND);
        }
 
        relationshipBO.deleteById(id);        
        return new ResponseEntity<Relationship>(HttpStatus.NO_CONTENT);
        
	}

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Relationship>> getUserProfiles(@PathVariable("userId") Long userId) {
		List<Relationship> relationList = relationshipBO.list(userId);
		return new ResponseEntity<List<Relationship>>(relationList, HttpStatus.OK);	
	}
	
}
